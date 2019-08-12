package com.springbook.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ViewResolver viewResolver;
    
    public void init() throws ServletException {
    	viewResolver = new ViewResolver();
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// 1. 클라이언트의 요청 path 정보를 추출한다.
		
		String url = request.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"));
		System.out.println(path);
		
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("글 목록 검색 처리");
		}
	}
}