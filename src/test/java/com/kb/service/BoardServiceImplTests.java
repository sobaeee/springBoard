package com.kb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kb.domain.BoardVO;
import com.kb.domain.Criteria;
import com.kb.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceImplTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	//@Test
	public void testRegister() {
		
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성한 글");
		board.setContent("새로 작성한 내용");
		board.setWriter("newbie");
		service.register(board);
	}
	
	@Test
		public void getListWithPaging() {
			Criteria cri = new Criteria();
			service.getListWithPaging(cri);
		}
	
	//@Test
	public void getList() {
		service.getList();
	}
	
	//@Test
	public void get() {
		service.get(786407);
	}
	
	//@Test
	public void modify() {
		
		BoardVO board = new BoardVO();
		board.setBno(786407);
		board.setTitle("수정한 글");
		board.setContent("수정한 내용");
		board.setWriter("newbie");
		service.modify(board);
	}
	
	//@Test
	public void remove() {
		service.remove(786407);
	}
}
