package com.eboji;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.eboji.boot.MvcConfig;
import com.eboji.boot.RootConfig;

import junit.framework.TestCase;

/**
 * 集成WEB环境方式测试Controller
 * @author zhoucl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({  
    @ContextConfiguration(name = "parent", classes = RootConfig.class),  
    @ContextConfiguration(name = "child", classes = MvcConfig.class)  
})
@Transactional
@WebAppConfiguration(value = "webapp-quickstart/src/main/webapp")
public class BaseTestCase extends TestCase {
	@Test
	public void defaultTest() {
		Assert.assertEquals(1, 1);
	}
}
