package com.kb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kb.domain.AuthorVO;
import com.kb.domain.MemberCriteria;
import com.kb.domain.MemberVO;
import com.kb.mapper.AuthorMapper;
import com.kb.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Service
@Log4j
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private AuthorMapper authMapper;
	
	
	@Override
	@Transactional
	public void register(MemberVO member) {
		log.info("register");
		mapper.insert(member);
		if(member.getAuthList() != null) {
		authMapper.insert(member.getAuthList().get(0));   
		//↑이 한 줄이 있으면 restcontroller에 create가 작동을 안함. 주석시 작동.
		}
	}

	@Override
	public MemberVO get(int num) {
		return mapper.read(num);
	}

	@Override
	public boolean modify(MemberVO member) {
		return mapper.update(member) == 1;
	}

	@Override
	public boolean remove(int num) {
		return mapper.delete(num) == 1;
	}

	@Override
	public List<MemberVO> getList() {
		log.info("getList........................");
		return mapper.getList();
	}

	@Override
	public List<MemberVO> getListWithPaging(MemberCriteria cri) {
		log.info("getList........................");
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getListWithCnt(MemberCriteria cri) {
		log.info("getList........................");
		return mapper.getListWithCnt(cri);
	}

	@Override
	public List<AuthorVO> readAuthsByUid(String uid) {
		
		List<AuthorVO> list = authMapper.readAuthsByUid(uid);
		
		return list;
		
	}

	@Override
	public void insertAuthByUid(AuthorVO vo) {
		authMapper.insert(vo);
		
	}
	
	
	
}
