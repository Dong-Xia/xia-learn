package com.aspire.commom.junit;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试公共类
 * @author xia
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application-context.xml")  //这两行主要是为了让测试类继承的
public class SpringJunitTest {
	
}
