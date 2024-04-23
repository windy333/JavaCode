package service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DBUtil;


@WebServlet(description="LoginServlet",urlPatterns= {"/LoginServlet"})

public class LoginServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String userName=request.getParameter("userName");
		String userPwd=request.getParameter("userPwd");
		
		DBUtil db=new DBUtil();
		db.getConn();
	
		//查询
		ResultSet rs=db.getResult("select * from t_user where userName=? and userPwd=?",new String[]{userName,userPwd});
		try {
			if(rs!=null && rs.next()){	//如果有一条记录就返回
			HttpSession session=request.getSession();
			session.setAttribute("userName",userName);
			request.getRequestDispatcher("GetAllArticleServlet").forward(request,response);
			}
		else {
			response.sendRedirect("login.jsp");//?request
			//request.setAttribute("message”,用户名或密码错误）；
			//response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			}finally {
				if(db!=null) db.release();
			}
		}
}

