package com.asmi.cglib;

public class SampleBean {
	
	private String value;
	private String code;

	public SampleBean() {
	}

	public SampleBean(String value) {
		this.value = value;
	}

	public SampleBean(String value,String code) {
		this.code = code;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}