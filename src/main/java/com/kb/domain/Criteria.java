package com.kb.domain;

import lombok.Data;
@Data
public class Criteria {
	
	private int pageNum; //현재 페이지 번호
	private int amount; //한 페이지당 보여줄 게시글 수
	
	
	public Criteria() {
		this(1,10);
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public int getPageStart() {
		return (getPageNum() - 1) * getAmount();
	}
}
