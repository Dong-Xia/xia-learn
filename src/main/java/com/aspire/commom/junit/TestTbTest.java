package com.aspire.commom.junit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aspire.core.bean.TestTb;
import com.aspire.core.service.TestTbservice;

public class TestTbTest extends SpringJunitTest  {

	@Autowired
	private TestTbservice testTbservice;
	
	@Test
	public void testAdd() throws Exception{
		TestTb testTb=new TestTb();
		testTb.setName("卓望");
		
		testTbservice.addTestTb(testTb);
	}
}
