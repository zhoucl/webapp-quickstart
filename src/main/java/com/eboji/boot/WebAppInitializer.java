package com.eboji.boot;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(1)
public class WebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		/**
		 * 读取conf文件夹中的logback.xml配置文件
		 * warParent:/home/zhoucl/var/server/tomcat5/webapps/webapp-quickstart/
		 */
		
		/** 正式环境打开此处代码，根据应用服务器修改logback对应的配置目录
		String warParent = servletContext.getRealPath("/");
		warParent.substring(0, warParent.lastIndexOf("webapps"));
		String logback = warParent + "logback-conf/logback.xml";
		
		File logbackFile = new File(logback);
		if (logbackFile.exists()) {
           LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
           JoranConfigurator configurator = new JoranConfigurator();
           configurator.setContext(lc);
           lc.reset();
           try {
               configurator.doConfigure(logbackFile);
           }
           catch (JoranException e) {
               e.printStackTrace(System.err);
               System.exit(-1);
           }
       }*/
		
		super.onStartup(servletContext);
		
		Dynamic regist = servletContext.addFilter("encoding", CharacterEncodingFilter.class);
		regist.setInitParameter("encoding", "UTF-8");
		regist.setInitParameter("forceEncoding", "true");
		regist.setAsyncSupported(true);
		regist.addMappingForUrlPatterns(null, true, "/");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { MvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
