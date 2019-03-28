package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.TestDTO;

@Repository
public class TestDAOImpl implements TestDAO{

	@Inject
	private SqlSession sqlSession;
	
	private final String NS="kr.co.mapper.test";

	@Override
	public List<TestDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+".list");
	}

	@Override
	public void insert(TestDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.insert(NS+".insert",dto);
	}

	@Override
	public TestDTO selectByNum(int num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".selectByNum", num);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		sqlSession.delete(NS+".delete", num);
	}

	@Override
	public TestDTO updateui(int num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".updateui", num);
	}

	@Override
	public void update(TestDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update(NS+".update", dto);
	}

}
