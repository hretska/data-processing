package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phones.Mock;
import phones.phones;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import crud.Lab2CrudInterface;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1/*")
public class Servlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 private List<phones> lp = new Mock().getPhonesList();
 
 ServletConfigInterface servletConfig;
 Lab2CrudInterface lab2Crud;
 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        this.servletConfig = new ServletConfig();
        this.lab2Crud = servletConfig.getCrud();
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	 setAccessControlHeaders(response);
	 response.setContentType("application/json");
	 response.getWriter().println(lp);
	 
	 ///PrintWriter out = response.getWriter();
  ///out.println("["+lab2Crud.readPhones()+"]");
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 setAccessControlHeaders(response);
	 doGet(request, response);
 }

 /**
  * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
  */
 protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	 setAccessControlHeaders(response);
	 doGet(request, response);

//  String title = request.getParameter("title");
//  int power = Integer.parseInt(request.getParameter("power"));
//  float price = Float.parseFloat(request.getParameter("price"));
//  
//  lab2Crud.updatePhones(new phones(title,power,price));
 }

 /**
  * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
  */
 protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 setAccessControlHeaders(response);
	 }
 
 protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 setAccessControlHeaders(response);
	 response.setStatus(HttpServletResponse.SC_OK);
	 
 }
 
 private void setAccessControlHeaders(HttpServletResponse resp) {
	 resp.setHeader("Access-Control.Allow-Origin", "*");
	 resp.setHeader("Access-Control.Allow-Methods", "*");
	 resp.setHeader("Access-Control.Allow-Headers", "*");
 }


}