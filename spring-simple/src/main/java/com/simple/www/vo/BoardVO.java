package com.simple.www.vo;

import java.sql.Date;

public class BoardVO {
	private int b_no;
	private int b_mno;
	private String b_body;
	private Date b_date;
	private String m_id;
	private String a_img;
	
	
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getA_img() {
		return a_img;
	}
	public void setA_img(String a_img) {
		this.a_img = a_img;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public int getB_mno() {
		return b_mno;
	}
	public void setB_mno(int b_mno) {
		this.b_mno = b_mno;
	}
	public String getB_body() {
		return b_body;
	}
	public void setB_body(String b_body) {
		this.b_body = b_body;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	
	
}
