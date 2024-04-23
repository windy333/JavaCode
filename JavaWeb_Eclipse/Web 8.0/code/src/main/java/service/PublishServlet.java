package service;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DBUtil;
import model.User;

@WebServlet(description="PublishServlet",urlPatterns= {"/PublishServlet"})

public class PublishServlet extends HttpServlet {
	public  void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String articType=request.getParameter("articType");
		String articTitle=request.getParameter("articTitle");
		String articContent=request.getParameter("articContent");
		//User user=(User)request.getSession().getAttribute("user");
		//String articAuthor=user.getUserName();
		HttpSession session=request.getSession();
		String articAuthor=(String)session.getAttribute("userName");
		if(articType==null||articTitle==""||articContent==null||articContent=="") {
			request.setAttribute("message","文章标题和文章内容不能为空");
			request.getRequestDispatcher("publish.jsp").forward(request,response);
		}
		else {
			PreparedStatement ptat=null;
			int result=0;
			DBUtil db=new DBUtil();
			Connection connection=db.getConn();//建立连接
			try {
				ptat=connection.prepareStatement("insert into t_article(articType,articTitle,"
						+ "articContent,"+"articAuthor,artciTime)value(?,?,?,?,?)");
			ptat.setString(1, articType);
			ptat.setString(2, articTitle);
			ptat.setString(3, articContent);
			ptat.setString(4, articAuthor);
			ptat.setDate(5,new Date(System.currentTimeMillis()));
			result=ptat.executeUpdate();
			
			if(result>0) {				//成功插入
				System.out.println("success发表成功");
				request.getRequestDispatcher("user.jsp").forward(request,response);
			}
			else {//失败
				System.out.println("error发表失败");
				//request.getRequestDispatcher("GetAllArticleServlet").forward(request,response);
				request.getRequestDispatcher("user.jsp").forward(request,response);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(db!=null) db.release();
				}
			
		}
	}
}
