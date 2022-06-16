package com.kb.service;

import java.util.List;

import com.kb.domain.BoardVO;
import com.kb.domain.MemberCriteria;
import com.kb.domain.MemberVO;
import com.kb.domain.AuthorVO;
import com.kb.domain.BoardCriteria;

public interface MemberService {
	
	public void register(MemberVO board); //insert
	
	public MemberVO get(int num); //read
	
	public boolean modify(MemberVO board); //update
	
	public boolean remove(int num); //delete
	
	public List<MemberVO> getList(); //List
	
	public List<MemberVO> getListWithPaging(MemberCriteria cri);

	public int getListWithCnt(MemberCriteria cri);

	public List<AuthorVO> readAuthsByUid(String uid);

	public void insertAuthByUid(AuthorVO vo);
}
