package com.aspire.core.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileUploadService {

	String upload(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
