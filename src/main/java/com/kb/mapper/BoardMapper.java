package com.kb.mapper;

import java.util.List;

import com.kb.domain.BoardVO;
import com.kb.domain.BoardCriteria;

public interface BoardMapper {
	
	public List<BoardVO> getList(); //getList가 BoardMapper id가 된다.
	
	public List<BoardVO> getListWithPaging(BoardCriteria cri);
	
	public void insert(BoardVO board);
	
	public BoardVO read(int bno);
	
	public int update(BoardVO board);
	
	public int delete(int bno);

	public int getListWithCnt(BoardCriteria cri);
}
