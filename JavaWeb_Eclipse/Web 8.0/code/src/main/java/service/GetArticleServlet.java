package service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBUtil;
import model.Articles;

@WebServlet(description="GetArticleServlet",urlPatterns= {"/GetArticleServlet"})

public class GetArticleServlet extends HttpServlet {

	public GetArticleServlet() {
		super();
	}

	public void destroy(){
		super. destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		int articID = Integer. parseInt(request. getParameter("articID"));
		Articles article;
		DBUtil db=new DBUtil();
		db. getConn();			//1. 得到连接
		
		ResultSet rs=db. getResult(" select * from t_article where articID="+articID);//2. 查询记录
		try {
			if(rs. next()){
				article=new Articles();
				article.setArticID(rs. getInt("articID"));
				article.setArticType(rs. getString("articType"));
				article.setArticTitle(rs. getString("articTitle"));
				article.setArticContent(rs. getString("articContent"));
				article.setArticAuthor(rs. getString("articAuthor"));
				article.setArticTime(rs. getDate("articTime"));
				request.setAttribute("article", article);
				
				
				request.getRequestDispatcher("content.jsp"). forward(request,response);
			}
		} catch(SQLException e){
			e. printStackTrace();
		}finally{
			if(db!=null)
				db.release();
		}
	}
	
	public void init() throws ServletException{
		// Put your code here
	}


}

