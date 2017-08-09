package com.aspire.core.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aspire.core.bean.FileQuery;

public interface FileUploadService {

	String upload(HttpServletRequest request, HttpServletResponse response) throws IOException;

	 Map<String,Object> queryPage(FileQuery file);

	void deleteFile(String fileId);

}
