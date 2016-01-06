package com.eboji.boot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Bean主配置类
 * @author zhoucl
 */
@Configuration
@ComponentScan(value = { "com.eboji" },
	excludeFilters = 
	{ 
		@ComponentScan.Filter(type = FilterType.ANNOTATION, 
			value = {
				Controller.class,
				RestController.class
			}
		)
	}
)
public class SpringConfig {

}
