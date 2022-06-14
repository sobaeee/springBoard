package com.kb.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kb.domain.MemberCriteria;
import com.kb.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {

	@Setter(onMethod_ = @Autowired)
	MemberMapper mapper;

	//@Test
	public void getListTest() {
		log.info(mapper.getList());
	}
	
	//@Test
	public void getListWithPaging() {
		MemberCriteria cri = new MemberCriteria();
		cri.setPageNum(1);
		cri.setAmount(20);
		cri.setType("uname");
		cri.setKeyword("안쌤");
		List<MemberVO> list = mapper.getListWithPaging(cri);
		list.forEach(member -> log.info(member));
	}

}
