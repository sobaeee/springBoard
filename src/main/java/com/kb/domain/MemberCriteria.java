package com.kb.domain;

import lombok.Data;
@Data
public class MemberCriteria {
	
	private int pageNum; //현재 페이지 번호
	private int amount; //한 페이지당 보여줄 게시글 수
	
	private String type;
	private String keyword;
	
	
	public MemberCriteria() {
		this(1,5);
	}
	public MemberCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public int getPageStart() {
		return (getPageNum() - 1) * getAmount();
	}
}
