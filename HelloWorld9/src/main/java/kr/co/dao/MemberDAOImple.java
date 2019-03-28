package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.MemberDTO;

@Repository
public class MemberDAOImple implements MemberDAO{

	@Inject
	private SqlSession sqlSession;
	
	private final String NS="kr.co.mapper.Member";
	
	@Override
	public void insert(MemberDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.insert(NS+".insert",dto);
	}

	@Override
	public List<MemberDTO> select() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+".select");
	}

	@Override
	public MemberDTO selectById(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".selectById",id);
	}

	@Override
	public MemberDTO updateui(int id) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(NS+".updateui", id);
	}

	@Override
	public void update(MemberDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update(NS+".update",dto);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sqlSession.delete(NS+".delete", id);
	}

	

}
