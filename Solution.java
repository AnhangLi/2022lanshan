package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.CallableStatement;


class Lost{
	int id;
	String name;
	Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return " name=" + name + ", date=" + date;
	}
	
	
	
}
class Card extends Lost{
	String type;

	

	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return super.toString();
	}
	
}
class Book extends Lost{
String type;

	

	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
public class Solution{
		
		/**
	     * 失物排序方法
	     * @param lostArray 待排序的失物数组 
	     */
	    public static void sortLost(Lost[] lostArray){
	    	for(int i = 0; i < lostArray.length - 1; i++) { 
                for (int j = i + 1; j < lostArray.length; j++) { 
                    if (lostArray[i].getDate().getTime() < lostArray[i].getDate().getTime()) { 
                        Lost l = lostArray[i];
                        lostArray[i] = lostArray[j];
                        lostArray[j] = l;
                    }
                }
            }
	    }
	    
	    /**
	     * 按关键字搜索失物的方法，这里假设按照失物的领取地点进行搜索
	     * @param lostArray 失物数组 
	     * @param keyword 用户输入的关键字
	     * @return 返回查找到的失物
	     */
	    public static Lost[] selectByKeyword(Lost[] lostArray,String keyword){
	    	Lost[] lostArrays=new Lost[3];
	    	int total=0;
	    	for(int i=0;i<lostArray.length;i++) {
	    		if(lostArray[i].getName().contains(keyword)) {
	    			lostArrays[total]=lostArray[i];
	    			total++;
	    		}
	    	}
			return lostArrays;
	        
	    }
	    public static String username = "root";
		public static String url = "jdbc:mysql://localhost:3306/lost?useSSL=false&serverTimezone=UTC";
		public static String password = "root";
		private static final String driver = "com.mysql.jdbc.Driver";
		private static Connection conn = null;
		private static PreparedStatement ps = null;
		private static ResultSet rs = null;
		private static final CallableStatement cs = null;

		public static Connection conn() {
			Connection conn = null;
			try {
				Class.forName(driver);  
				try {
					conn = DriverManager.getConnection(url, username, password);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return conn;
		}
		public static  Lost[] SelectStudent() {
			// TODO Auto-generated method stub
			Lost[] lost=new Lost[3];
			String sql="select * from lost";
			int total=0;
			try {
				conn=conn();
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()) {
					if(rs.getString("type").equals("book")) {
						Book b=new Book();
						b.setId(rs.getInt("id"));
						b.setDate(rs.getDate("time"));
						b.setName(rs.getString("name"));
						b.setType("book");
						lost[total]=b;
					}else if(rs.getString("type").equals("card")) {
						Card b=new Card();
						b.setId(rs.getInt("id"));
						b.setDate(rs.getDate("time"));
						b.setName(rs.getString("name"));
						b.setType("card");
						lost[total]=b;
					}
					total++;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lost;
		}
		public static void main(String args[]) {
			Lost[] lost=SelectStudent();
			sortLost(lost);
			Lost[] losts=selectByKeyword(lost, "西");
			if(losts.length>0) {
				for(int i=0;i<losts.length;i++) {
					if(losts[i]!=null) {
						System.out.println(losts[i]);
					}
				}
			}
		}
	    
	}

