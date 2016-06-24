package com.eboji.converter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.util.IOUtils;

public class FastJsonpHttpMessageConverter extends
		FastJsonHttpMessageConverter {
	protected String[] jsonpParameterNames = new String[]{"callback","jsonp"};
	
	@Override
	protected void writeInternal(Object obj, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		
		String content = JSON.toJSONString(obj);
		String callback = null;
		
		for(String param : jsonpParameterNames) {
			callback = request.getParameter(param);
			if(callback != null)
				break;
		}
		
		if(!StringUtils.isEmpty(callback)) {
			content = new StringBuilder(callback).append("(").append(content).append(")").toString();
		}
		
		outputMessage.getBody().write(content.getBytes(IOUtils.UTF8));
	}

	public void setJsonpParameterNames(String[] jsonpParameterNames) {
		this.jsonpParameterNames = jsonpParameterNames;
	}
}
