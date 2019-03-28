package kr.co.ca;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dao.BoardDAO;
import kr.co.dao.ReplyDAO;
import kr.co.domain.BoardVO;
import kr.co.domain.ReplyVO;
import kr.co.domain.SearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyDAOTest {
	
	@Inject
	private ReplyDAO dao;
	
	@Test
	public void testinsert() {
		// TODO Auto-generated method stub
		/*
		 * Integer rno = createRno();
		 * 
		 * if(rno == null) { rno = 1; } else { rno++; }
		 * 
		 * vo.setRno(rno);
		 * 
		 * session.insert(NS+".insert", vo);
		 */
		
		ReplyVO vo = new ReplyVO(1, 156, "성공?", "나야나", null, null);
		
		dao.insert(vo);
	}
	
	@Test
	public void testlist() {

		List<ReplyVO>list = dao.list(156);
		for(ReplyVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Test
	public void testupdate() {
		
		ReplyVO vo = new ReplyVO(1, 156, "성공?", "나야나", null, null);
		dao.update(vo);
	}

	@Test
	public void testdelete() {
		
		int rno = 17;
		dao.delete(rno);
	}
}
