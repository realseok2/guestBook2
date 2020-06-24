package com.javaex.vo;

public class PersonVo {

//------------------------------------------------------------------------------------		필드

	private int No; // 게시물 코드
	private String Name; // 작성자 이름
	private String Pw; // 작성글 패스워드
	private String Content; // 작성글 내용
	private String Date; // 작성글 날짜

//------------------------------------------------------------------------------------		생성자

	public PersonVo(int no, String pw) {
		this.No = no;
		this.Pw = pw;
	}

	public PersonVo(String name, String pw, String content) {
		this.Name = name;
		this.Pw = pw;
		this.Content = content;
	}
	
	public PersonVo(int no, String name, String pw, String content) {
		this.No = no;
		this.Name = name;
		this.Pw = pw;
		this.Content = content;
	}

	public PersonVo(int no, String name, String pw, String content, String date) {
		this.No = no;
		this.Name = name;
		this.Pw = pw;
		this.Content = content;
		this.Date = date;
	}

//------------------------------------------------------------------------------------		getter, setter

	public int getNo() {
		return No;
	}

	public void setNo(int no) {
		No = no;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPw() {
		return Pw;
	}

	public void setPw(String pw) {
		Pw = pw;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

//------------------------------------------------------------------------------------		일반 메소드

	
	
	
	
	
	
	
	
	
//------------------------------------------------------------------------------------		toString()

	@Override
	public String toString() {
		return "PersonVo [No=" + No + ", Name=" + Name + ", Pw=" + Pw + ", Content=" + Content + ", Date=" + Date + "]";
	}
}