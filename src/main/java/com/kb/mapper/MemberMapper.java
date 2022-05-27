package com.kb.mapper;

import java.util.List;

import com.kb.domain.BoardVO;
import com.kb.domain.MemberCriteria;
import com.kb.domain.MemberVO;
import com.kb.domain.BoardCriteria;

public interface MemberMapper {
	
	public List<MemberVO> getList(); //getList가 BoardMapper id가 된다.
	
	public List<MemberVO> getListWithPaging(MemberCriteria cri);
	
	public void insert(MemberVO board);
	
	public MemberVO read(int num);
	
	public int update(MemberVO board);
	
	public int delete(int num);

	public int getListWithCnt(MemberCriteria cri);
}
