package com.ssoh.utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtility {
	
	public static void setEncoding(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void alert(HttpServletResponse response, String alertMessage) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+alertMessage+"')");
		out.println("</script>");
		out.flush();
	}
	
	public static void alertAndNextPage(HttpServletResponse response,String alertMessage,String nextPage) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+alertMessage+"');");
		out.println("location.href='"+nextPage+"';");
		out.println("</script>");
		out.flush();
	}
	
	public static void alertAndBackPage(HttpServletResponse response,String alertMessage) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+alertMessage+"');");
		out.println("history.back();");
		out.println("</script>");
		out.flush();
	}
	
	public static void nextPage(HttpServletResponse response,String nextPage) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("location.href='"+nextPage+"'");
		out.println("</script>");
		out.flush();
	}
}
