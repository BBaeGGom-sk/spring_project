package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession session; // 세션 연결

	private final String NS = "kr.co.mapper.reply"; // 네임 스페이스 연결

	@Override
	public void insert(ReplyVO vo) {
		// TODO Auto-generated method stub

		Integer rno = createRno();


		vo.setRno(rno);

		session.insert(NS + ".insert", vo);
	}

	private Integer createRno() {
		// TODO Auto-generated method stub
		Integer rno = session.selectOne(NS + ".createRno");
		if (rno == null) {
			rno = 1;
		} else {
			rno++;
		}
		return  rno;
	}

	@Override
	public List<ReplyVO> list(int bno) {
		// TODO Auto-generated method stub
		
		return session.selectList(NS+".list", bno);
		
	}

	@Override
	public void update(ReplyVO vo) {
		// TODO Auto-generated method stub
		
		session.update(NS+".update", vo);
	}

	@Override
	public void delete(int rno) {
		// TODO Auto-generated method stub
		
		session.delete(NS+".delete", rno);
		
	}

}
