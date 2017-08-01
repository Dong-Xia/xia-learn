package com.aspire.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aspire.core.bean.TestTb;
import com.aspire.core.dao.TestTbDao;

@Service
public class TestTbserviceImpl implements TestTbservice {

	@Resource
	private TestTbDao testTbDao;
	
	public void addTestTb(TestTb testTb) {
		testTbDao.addTestTb(testTb);
	}
	
	
}
