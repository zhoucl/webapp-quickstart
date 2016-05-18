package com.eboji.boot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.eboji" },
	includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, 
			value = {
				Controller.class,
				RestController.class
			}
		)
	}
)
public class MvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations(
				"/static/");
	}
	
	@Bean(name="viewResolver")
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setWriteAcceptCharset(false);
        
        FastJsonHttpMessageConverter jsonConverter = new FastJsonHttpMessageConverter();
        List<MediaType> jsonMediaTypes = new ArrayList<MediaType>();
        jsonMediaTypes.add(MediaType.valueOf(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));
        jsonMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        jsonConverter.setSupportedMediaTypes(jsonMediaTypes);
        
        Jaxb2RootElementHttpMessageConverter xmlConverter = new Jaxb2RootElementHttpMessageConverter();
        List<MediaType> xmlMediaTypes = new ArrayList<MediaType>();
        xmlMediaTypes.add(MediaType.valueOf(MediaType.TEXT_XML_VALUE + ";charset=UTF-8"));
        xmlMediaTypes.add(MediaType.valueOf(MediaType.APPLICATION_XML_VALUE + ";charset=UTF-8"));
        xmlConverter.setSupportedMediaTypes(xmlMediaTypes);
        
        converters.add(stringConverter);
        converters.add(jsonConverter);
        converters.add(xmlConverter);
		super.configureMessageConverters(converters);
	}
	
	
}
