package com.sds.icto.board.vo;

public class BoardVo {
	private Long   no;
	private String title;
	private String content;
	private Long   memberno;
	private String name;
	private Long   viewcount;
	private String sysdate;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getMemberno() {
		return memberno;
	}
	public void setMemberno(Long memberno) {
		this.memberno = memberno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getViewcount() {
		return viewcount;
	}
	public void setViewcount(Long viewcount) {
		this.viewcount = viewcount;
	}
	public String getSysdate() {
		return sysdate;
	}
	public void setSysdate(String sysdate) {
		this.sysdate = sysdate;
	}
	
	
}
