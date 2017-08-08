package com.aspire.core.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;

import com.aspire.core.bean.ProgressBar;
import com.aspire.core.dao.FileUploadDao;

@Service
public class FileUploadServiceImpl implements FileUploadService{

	@Resource
	private FileUploadDao fileUploadDao;

	@Override
	public String upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter pout = response.getWriter();
		try {
			// 得到存放上传文件的真实路径
			String storePath = request.getServletContext()
					.getRealPath("/WEB-INF/files");
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
			upload.setProgressListener(new ProgressListener() {
				//pBytesRead：当前以读取到的字节数
				//pContentLength：文件的长度
				//pItems:第几项
				public void update(long pBytesRead, long pContentLength,
						int pItems) {
					System.out.println("已读取："+pBytesRead+",文件大小："+pContentLength+",第几项："+pItems);
				}
			});
			
			upload.setFileSizeMax(20 * 1024 * 1024);// 设置单个上传文件的大小
			upload.setSizeMax(30 * 1024 * 1024);// 设置总文件大小
			
			// 解析
			@SuppressWarnings("unchecked")
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					// 普通字段
					String fieldName = item.getFieldName();
					String fieldValue = item.getString("UTF-8");
					System.out.println(fieldName + "=" + fieldValue);
				} else {
					// 得到MIME类型
					String mimeType = item.getContentType();
					// 只允许上传图片
					 if(mimeType.startsWith("audio")){
						// 上传字段
						InputStream in = item.getInputStream();
						// 上传的文件名
						String fileName = item.getName();// C:\Documents and
						System.out.println(item.getSize());
						System.out.println(fileName);
						if(fileName==null||"".equals(fileName.trim())){
							continue;
						}
						// Settings\wzhting\妗岄潰\a.txt
						// a.txt
						fileName = fileName
								.substring(fileName.lastIndexOf("\\") + 1);// a.txt
						fileName = UUID.randomUUID() + "_" + fileName;
						System.out.println(request.getRemoteAddr()+"=============="+fileName);
						// 构建输出流
						// 打散存储目录
						String newStorePath = makeStorePath(storePath, fileName);// 根据
						// /WEB-INF/files和文件名，创建一个新的存储路径
						// /WEB-INF/files/1/12
						String storeFile = newStorePath + "\\" + fileName;// WEB-INF/files/1/2/sldfdslf.txt
	
						OutputStream out = new FileOutputStream(storeFile);
	
						byte b[] = new byte[1024];
						int len = -1;
						while ((len = in.read(b)) != -1) {
							out.write(b, 0, len);
						}
						out.close();
						in.close();
						item.delete();//删除临时文件
					}
				 }
			}
		} catch (org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException e) {
			// 单个文件超出大小时的异常
			pout.write("单个文件大小不能超出4M");
		} catch (org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException e) {
			// 总文件超出大小时的异常
			pout.write("总文件大小不能超出6M");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// 根据 /WEB-INF/files和文件名，创建一个新的存储路径 /WEB-INF/files/1/12
	private String makeStorePath(String storePath, String fileName) {
		int hashCode = fileName.hashCode();
		int dir1 = hashCode & 0xf;// 0000~1111：整数0~15共16个
		int dir2 = (hashCode & 0xf0) >> 4;// 0000~1111：整数0~15共16个

		String path = storePath + "\\" + dir1 + "\\" + dir2; // WEB-INF/files/1/12
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();

		return path;
	}
}
