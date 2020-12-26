package com.ge.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSrv extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
	
			//reading form data
			String name=req.getParameter("t1");
			String pass=req.getParameter("t2");
			//convertion
			name="'"+name+"'";
			pass="'"+pass+"'";
			
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			String qry=null;
			int result=0;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
				st=con.createStatement();
				qry="select count(*) from register where uname="+name+" and pwd="+pass;
				rs=st.executeQuery(qry);
				
				while(rs.next())
				{
					result=rs.getInt(1);
				}
				if(result==0)
				{
					RequestDispatcher rd=req.getRequestDispatcher("error.jsp");
					rd.forward(req,res);
					
				}
				else
				{
					RequestDispatcher rd=req.getRequestDispatcher("mainpage4.jsp");
					rd.forward(req,res);
				}
				
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception e)
			{
				pw.println(e);
			}
	
	}

}
