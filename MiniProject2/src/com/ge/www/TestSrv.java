package com.ge.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestSrv extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			
			//reading form data
			String name=req.getParameter("t1");
			String pass=req.getParameter("t2");
			String cpass=req.getParameter("t3");
			String email=req.getParameter("t4");
			
			
			Connection con=null;
			PreparedStatement ps=null;
			String qry=null;
			int result=0;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
				qry="insert into register values(?,?,?,?)";
				ps=con.prepareStatement(qry);
				//set the values
				ps.setString(1, name);
				ps.setString(2,pass);
				ps.setString(3,cpass);
				ps.setString(4,email);
				
				result=ps.executeUpdate();
				
				if(result==0)
				{
					pw.println("No Record inserted");
				}
				else
				{
					RequestDispatcher rd=req.getRequestDispatcher("mainpage3.jsp");
					rd.forward(req,res);
				}
				ps.close();
				con.close();
			
			}
			catch(Exception e)
			{
				pw.println(e);
			}
			
	}

}
