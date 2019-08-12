package com.springbook.view.controller;

import org.springframework.web.servlet.ModelAndView;

public class ViewResolver {
	public String prefix;
	public String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getView(ModelAndView viewName) {
		return prefix + viewName + suffix;
	}
}
