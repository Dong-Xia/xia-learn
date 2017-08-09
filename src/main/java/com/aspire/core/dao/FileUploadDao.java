package com.aspire.core.dao;

import java.util.Date;
import java.util.List;

import com.aspire.core.bean.FileQuery;
import com.aspire.core.bean.Program;

public interface FileUploadDao {

	void insertFile(Program program);

	List<Program> queryPage(FileQuery file);

	int getCountRecouds(FileQuery file);

	void deleteFile(String fileId);


}
