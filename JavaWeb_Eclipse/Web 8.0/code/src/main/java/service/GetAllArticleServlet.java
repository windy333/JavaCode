package service;
import java.io.IOException;
import java. sql. ResultSet;
import java. sql. SQLException;
import java. util. ArrayList;
import java. util. List;
import javax. servlet. ServletException;
import javax. servlet. annotation. WebServlet;
import javax. servlet.http.HttpServlet;
import javax. servlet. http.HttpServletRequest;
import javax. servlet.http.HttpServletResponse;
import utils.DBUtil;
import model.Articles;

@WebServlet(description="GetAllArticleServlet",urlPatterns= {"/GetAllArticleServlet"})

public class GetAllArticleServlet extends HttpServlet{

	public GetAllArticleServlet(){
		super();
	}

	public void destroy(){	
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
			
			List<Articles> articlesList=new ArrayList<Articles>();	//集合???
			Articles article;
			DBUtil db=new DBUtil();
			db.getConn();											//1.得到连接
			ResultSet rs=db.getResult("select * from t_article");	//2. 查询多条记录
			try{
				while(rs. next()){									//直到最后一条记录
					article=new Articles();
					article.setArticID(rs.getInt("articID"));
					System.out.println(rs.getInt("articID"));
					article.setArticType(rs.getString("articType"));
					article.setArticTitle(rs.getString("articTitle"));
					System.out.println(rs.getString("articTitle"));
					article.setArticContent(rs.getString("articContent"));
					article.setArticAuthor(rs.getString("articAuthor"));
					article.setArticTime(rs.getDate("articTime"));
					articlesList.add(article);
				}
			request.setAttribute("articlesList", articlesList);
			request.getRequestDispatcher("user.jsp").forward(request,response);
			} catch (SQLException e) {
				e. printStackTrace();
			}finally{
				if(db!=null);
				db.release();											//关闭连接
			}
	}
	
	public void init() throws ServletException {
		// Put your code here
	}
}

