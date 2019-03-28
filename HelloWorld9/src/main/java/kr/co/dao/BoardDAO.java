package kr.co.dao;

import java.util.List;

import kr.co.domain.BoardVO;
import kr.co.domain.Criteria;
import kr.co.domain.SearchCriteria;

public interface BoardDAO {
	
	List<BoardVO> list();

	void insert(BoardVO vo);

	BoardVO selectbybno(int num);

	BoardVO updateui(int bno);

	void delete(int bno);

	void update(BoardVO vo);

	List<BoardVO> listpage(Criteria cri);

	int getAmount();

	List<BoardVO> search(SearchCriteria cri);

	int getSearchAmount(SearchCriteria cri);

}
