package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MembersDAO;
import com.smhrd.model.MembersDTO;

public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	request.setCharacterEncoding("UTF-8");
	
	
	String mem_id = request.getParameter("mem_id");
	String mem_nick = request.getParameter("mem_nick");
	String mem_email = request.getParameter("mem_email");
	String mem_pw = request.getParameter("mem_pw");
	
	MembersDTO dto = new MembersDTO(mem_id, mem_pw, mem_nick, mem_email);
	MembersDAO dao = new MembersDAO();
	
	int result = dao.join(dto);
	
	if(result>0) {
//		RequestDispatcher rd = request.getRequestDispatcher("JoinTest.jsp");
//		rd.forward(request, response);
		
		// 회원가입성공시 자동로그인 - 구현중
//		HttpSession session = request.getSession();
//		MembersDTO join_result = dao.login(dto);
//		session.setAttribute("mem_info", join_result);
//		response.sendRedirect("Main.jsp");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('회원가입을 성공했습니다.'); location.href='Main.jsp';</script>");
		out.close();
		
				
	}else {
		response.sendRedirect("Main.jsp");
	}
	
	
	}

}
