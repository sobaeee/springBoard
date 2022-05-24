package com.kb.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	
	private int startPage; //시작페이지
	private int endPage; //끝페이지
	
	private boolean prev, next; //이전 다음
	
	private int total; //전체 레코드 수
	private Criteria cri; //현재페이지, 한 페이지당 보여줄 갯수
	
	public PageDTO(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/5.0))*5;
		
		this.startPage = this.endPage - 4;

//		아래로 수정하면 목록 누르는 버튼이 10까지 생성된다.
//		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
//		this.startPage = this.endPage - 9;
//		1에서 10까지 보여다오 -> 9    1에서 5까지 보여다오 -> 4.  끝-처음
		
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
	
	
}
