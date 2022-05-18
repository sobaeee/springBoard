package com.kb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.domain.BoardVO;
import com.kb.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	//BoardServiceImpl 마우스를 위에 올리면 <Add unimplemented methods> 를 클릭하면
	//Override가 아래에 다 생성이 된다.
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	
	

	@Override
	public void register(BoardVO board) {
		log.info("register");
		mapper.insert(board);
	}

	@Override
	public BoardVO get(int bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(int bno) {
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList........................");
		return mapper.getList();
	}

}
