package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.Criteria;
import kr.co.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject //sqlsession에 연결
	private SqlSession session;
	
	private final String NS="kr.co.mapper.board";//맵퍼에 있는 네임스페이스 복붙
	
	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return session.selectList(NS+".list");
	}

	@Override
	public void insert(BoardVO vo) {
		// TODO Auto-generated method stub
			
			Integer bno=createBno();
			if(bno==null) {
				bno=1;
			} else {
				bno++;
			}
			vo.setBno(bno);
			session.insert(NS+".insert", vo);

	}

	private Integer createBno() {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".createBno");
	}

	@Override
	public BoardVO selectbybno(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".selectbybno", bno);
	}

	@Override
	public BoardVO updateui(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".updateui", bno);
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		session.delete(NS+".delete", bno);
	}

	@Override
	public void update(BoardVO vo) {
		// TODO Auto-generated method stub
		session.update(NS+".update", vo);
	}

	@Override
	public List<BoardVO> listpage(Criteria cri) {
		// TODO Auto-generated method stub
		// 페이징 구현
		
		RowBounds rb = new RowBounds(cri.getStartNum()-1, cri.getPerpage());
		
		return session.selectList(NS+".list", 0, rb);
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".getAmount");
	}

	@Override
	public List<BoardVO> search(SearchCriteria cri) {
		// TODO Auto-generated method stub
		RowBounds rb = new RowBounds(cri.getStartNum()-1, cri.getPerpage());
		
		
		return session.selectList(NS+".search", cri, rb);
	}

	@Override
	public int getSearchAmount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".getSearchAmount", cri);
	}

	

}
