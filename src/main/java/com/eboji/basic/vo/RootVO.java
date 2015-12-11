package com.eboji.basic.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class RootVO {
	@XmlElementWrapper(name = "business-line")
	@XmlElement(required = true, name = "line")
	private List<BusinessLine> bizLine;

	public List<BusinessLine> getBizLine() {
		return bizLine;
	}

	public void setBizLine(List<BusinessLine> bizLine) {
		this.bizLine = bizLine;
	}
}
