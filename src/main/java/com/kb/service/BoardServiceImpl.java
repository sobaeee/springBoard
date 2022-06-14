package com.kb.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kb.domain.BoardVO;
import com.kb.domain.AttachFileDTO;
import com.kb.domain.BoardAttachVO;
import com.kb.domain.BoardCriteria;
import com.kb.mapper.BoardAttachMapper;
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
	
	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;
	
	
	
	@Override
	@Transactional
	public void register(BoardVO board) {
		log.info("register");
		mapper.insert(board);
		
		Iterator<BoardAttachVO> it = board.getAttachList().iterator();
		while(it.hasNext()) {
			BoardAttachVO attachVO = it.next();
			attachVO.setBno(board.getBno());
			attachMapper.insert(attachVO);
		}
	}

	@Override
	public BoardVO get(int bno) {
		BoardVO vo = mapper.read(bno);
		List<BoardAttachVO> attachList = attachMapper.read(bno);
		vo.setAttachList(attachList); //값을 전송해줘야함. 이게 없으면 전송이 안된다.
		 return vo;
	}

	@Override
	@Transactional
	public boolean modify(BoardVO board) {
		mapper.update(board);
		attachMapper.delete(board);
		
		Iterator<BoardAttachVO> it = board.getAttachList().iterator();
		while(it.hasNext()) {
			BoardAttachVO attachVO = it.next();
			attachVO.setBno(board.getBno());
			attachMapper.insert(attachVO);
		}
		
		return true;
	}
	

	@Override
	public boolean remove(int bno) {
		return mapper.delete(bno) == 1;
	}
	
	@Override
	@Transactional
	public boolean remove(BoardVO board) {
		attachMapper.delete(board);
		return mapper.delete(board.getBno()) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList........................");
		return mapper.getList();
	}

	@Override
	public List<BoardVO> getListWithPaging(BoardCriteria cri) {
		log.info("getList........................");
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getListWithCnt(BoardCriteria cri) {
		log.info("getList........................");
		return mapper.getListWithCnt(cri);
	}

	
}
