package com.eboji.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice
public class JSONPAdvice extends AbstractJsonpResponseBodyAdvice {
	public JSONPAdvice() {
		super("callback");
	}
}
