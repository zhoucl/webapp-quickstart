package com.eboji.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

import com.eboji.util.JmxClientUtil;

@Component
public class InitializationApplicationListener implements
		ApplicationListener<ApplicationEvent> {
	private static final Logger logger = LoggerFactory.getLogger(InitializationApplicationListener.class);
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		logger.info("InitializationApplicationListener...");
		
		if(event instanceof ContextStartedEvent) {
			//TODO 容器启动完成事件
			logger.info("ContextStartedEvent...");
		} else if(event instanceof ContextStoppedEvent) {
			//TODO 容器停止完成事件
			logger.info("ContextStoppedEvent...");
		} else if(event instanceof ContextRefreshedEvent) {
			//TODO 容器初始化完毕或者刷新事件
			logger.info("ContextRefreshedEvent...");
			logger.info("server port = " + JmxClientUtil.getTomcatPortByMBean());
		} else if(event instanceof ContextClosedEvent) {
			//TODO 容器关闭完成事件
			logger.info("ContextClosedEvent...");
		}
	}
	
}
