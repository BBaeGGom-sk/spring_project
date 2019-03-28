package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardVO;
import kr.co.domain.Criteria;
import kr.co.domain.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject //dao 호출
	private BoardDAO dao;

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public void insert(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public BoardVO selectbybno(int bno) {
		// TODO Auto-generated method stub
		return dao.selectbybno(bno);
	}

	@Override
	public BoardVO updateui(int bno) {
		// TODO Auto-generated method stub
		return dao.updateui(bno);
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}

	@Override
	public void update(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public List<BoardVO> listpage(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.listpage(cri);
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return dao.getAmount();
	}

	@Override
	public List<BoardVO> serach(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.search(cri);
	}

	@Override
	public int getSearchAmount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.getSearchAmount(cri);
	}



}
