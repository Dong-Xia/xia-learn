package com.aspire.core.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;

import com.aspire.commom.unit.MD5Utils;
import com.aspire.commom.unit.TimeUtils;
import com.aspire.core.bean.FileQuery;
import com.aspire.core.bean.Program;
import com.aspire.core.bean.TempDevice;
import com.aspire.core.bean.UploadProgressListener;
import com.aspire.core.dao.FileUploadDao;

@Service
public class FileUploadServiceImpl implements FileUploadService{

	@Resource
	private FileUploadDao fileUploadDao;

	//文件上传
	@Override
	public String upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter pout = response.getWriter();
		String frontPageMd5 = null;String backMd5 = null;
		try {
			// 得到存放上传文件的真实路径
			String storePath = request.getServletContext()
					.getRealPath("/WEB-INF/files");
			// 暂时存放目录（用于进行MD5教校验）
			String tempStorePath = request.getServletContext().getRealPath("/WEB-INF/temp");
			
				// 设置环境
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setRepository(new File(request.getServletContext().getRealPath("/temp")));//设置临时存放目录
				// 判断一下form是否是enctype=multipart/form-data类型的
				boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	/*			if(!isMultipart){ 
					request.setAttribute("result", "ERROR");
				}*/
				// ServletFileUpload核心类
				ServletFileUpload upload = new ServletFileUpload(factory);
				//文件上传进度的监听  
		        UploadProgressListener listener=new UploadProgressListener(request);  
		          
		        upload.setProgressListener(listener);  
				
				
	/*			upload.setProgressListener(new ProgressListener() {
					//pBytesRead：当前以读取到的字节数
					//pContentLength：文件的长度
					//pItems:第几项
					public void update(long pBytesRead, long pContentLength,
							int pItems) {
						
						//System.out.println("已读取："+pBytesRead+",文件大小："+pContentLength+",第几项："+pItems);
					}
				});*/
				
				upload.setFileSizeMax(20 * 1024 * 1024);// 设置单个上传文件的大小
				upload.setSizeMax(30 * 1024 * 1024);// 设置总文件大小
				
				// 解析
				@SuppressWarnings("unchecked")
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem item : items) {
					if (item.isFormField()) {
						String fieldName = item.getFieldName();
						frontPageMd5 = item.getString("UTF-8");
					} else { 
						// 得到MIME类型
						String mimeType = item.getContentType();
						// 只允许上传图片
						 if(mimeType.startsWith("audio")){
							// 上传字段
							InputStream in = item.getInputStream();
							// 上传的文件名
							String fileName = item.getName();// C:\Documents and
							String fileSize=String.valueOf(item.getSize());
							if(fileName==null||"".equals(fileName.trim())){
								continue;
							}
							
							fileName = fileName
									.substring(fileName.lastIndexOf("\\") + 1);// a.txt
							fileName =TimeUtils.getTimeFormat() + fileName.substring(item.getName().lastIndexOf("."));
							//临时目录
							String tempnewStorePath = makeStorePath(tempStorePath, fileName);// 根据
							String tempstoreFile = tempnewStorePath + "\\" + fileName;
							OutputStream tempout = new FileOutputStream(tempstoreFile);
							byte temp[] = new byte[1024];
							int templen = -1;
							while ((templen = in.read(temp)) != -1) {
								tempout.write(temp, 0, templen);
							}
							tempout.close();
							backMd5=MD5Utils.getMd5ByFile(new File(tempstoreFile));
							
							if(frontPageMd5.equals(backMd5)){
								InputStream in1 = item.getInputStream();
								// 构建输出流
								// 打散存储目录
								String newStorePath = makeStorePath(storePath, fileName);// 根据
								// /WEB-INF/files和文件名，创建一个新的存储路径
								// /WEB-INF/files/1/12
								String storeFile = newStorePath + "\\" + fileName;
								
								
								
								OutputStream out = new FileOutputStream(storeFile);
			
								byte b[] = new byte[1024];
								int len = -1;
								while ((len = in1.read(b)) != -1) {
									out.write(b, 0, len);
								}
								out.close();
								in1.close();
								
								
								Program program=new Program();
								program.setDuration(Integer.valueOf(getFileTime(storeFile)));
								String extension=item.getName().substring(item.getName().lastIndexOf("."));
								program.setExtension(extension);
								program.setMd5(frontPageMd5);
								program.setName(item.getName());
								program.setSize(fileSize);
								program.setRecordDateTime(new Date());
								program.setSystemFileName(TimeUtils.getTimeFormat()+extension);
								fileUploadDao.insertFile(program);
								
								item.delete();//删除临时文件
								return "上传成功";
							}else{
								return "MD5不匹配";
							}
						}
					 }
				}

		} catch (org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException e) {
			// 单个文件超出大小时的异常
			pout.write("单个文件大小不能超出20M");
		} catch (org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException e) {
			// 总文件超出大小时的异常
			pout.write("总文件大小不能超出30M");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 根据 /WEB-INF/files和文件名，创建一个新的存储路径 /WEB-INF/files/1/12
	private String makeStorePath(String storePath, String fileName) {

		String path = storePath; 
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();

		return path;
	}
	
	/**
	 * 获取上传的音频的时长
	 * @param path
	 * @return
	 */
	public String getFileTime(String path) {  
	    File file = new File(path);  
	    long total = 0;  
	    try {  
	        AudioFileFormat aff = AudioSystem.getAudioFileFormat(file);  
	        Map props = aff.properties();  
	        if (props.containsKey("duration")) {  
	            total = (long) Math.round((((Long) props.get("duration")).longValue()) / 1000);  
	        }  
	        return String.valueOf(total/1000);
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }
		return null;  
		
	}
	
	//分页查询文件信息
	@Override
	public Map<String,Object> queryPage(FileQuery file) {
		 Map<String,Object> fileMap=new HashMap<String,Object>();
		 
		 List<Program> fileList=fileUploadDao.queryPage(file);
		 //计算总的数量
		int totalRecouds=fileUploadDao.getCountRecouds(file); 
		Integer totalpages=totalRecouds%file.getPageSize()==0?totalRecouds/file.getPageSize():totalRecouds/file.getPageSize()+1;   //计算总页数
		fileMap.put("fileList",fileList );
		fileMap.put("totalPages", totalpages);
		
		return fileMap;
	}
	
	/**
	 * 删除文件
	 */
	@Override
	public void deleteFile(String fileId) {
		fileUploadDao.deleteFile(fileId);
	}
	
	
}
