package com.kb.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberPageDTO {
	
	private int startPage; //시작페이지
	private int endPage; //끝페이지
	
	private boolean prev, next; //이전 다음
	
	private int total; //전체 레코드 수
	private MemberCriteria cri; //현재페이지, 한 페이지당 보여줄 갯수
	private final int PAGE_NUM = 5;
	//10이면 아래 번호가 10개가 보이고 5이면 5개가 보인다
	
	public MemberPageDTO(int total, MemberCriteria cri) {
		this.total = total;
		this.cri = cri;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/(PAGE_NUM*1.0)))*PAGE_NUM;
		
		this.startPage = this.endPage - (PAGE_NUM-1);

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
