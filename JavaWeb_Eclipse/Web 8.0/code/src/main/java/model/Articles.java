package model;

import java.util.Date;

public class Articles {
	private Integer articID;
	private String articTyype;
	private String articTitle;
	private String articContent;
	private String articAuthor;
	private Date articTime;
	public Articles() {
		super();
	}
	
	
	public Articles(Integer articID,String articTyype, String articTitle,
			String articContent, String articAuthor, Date articTime) {
		super();
		this.articID=articID;
		this.articTyype=articTyype;
		this.articTitle=articTitle;
		this.articContent=articContent;
		this.articAuthor=articAuthor;
		this.articTime=articTime;
	}
	
	public Integer getArticID() {
		return articID;
	}
	
	public void setArticID(Integer articID) {
		this.articID=articID;
	}
	
	public String getArticType() {
		return articTyype;
	}
	
	public void setArticType(String articType) {
		this.articTyype=articType;
	}
	
	public String getArticTitle() {
		return articTitle;
	}
	
	public void setArticTitle(String articTitle) {
		this.articTitle=articTitle;
	}
	
	public String getArticContent() {
		return articContent;
	}
	
	public void setArticContent(String articContent) {
		this.articContent=articContent;
	}
	
	public String getArticAuthor() {
		return articAuthor;
	}
	
	public void setArticAuthor(String articAuthor) {
		this.articAuthor=articAuthor;
	}
	
	public Date getArticTime() {
		return articTime;
	}
	
	public void setArticTime(Date articTime) {
		this.articTime=articTime;
	}

@Override
	public String toString() {
		return "Articles[articID="+articID+
				",articType="+articTyype+
				",articTitle="+articTitle+
				",articContent="+articContent+
				",articAuthor="+articAuthor+
				",articTime="+articTime+"]";
	}
}
