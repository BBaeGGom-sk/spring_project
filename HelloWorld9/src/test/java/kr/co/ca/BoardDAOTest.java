package kr.co.ca;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardVO;
import kr.co.domain.SearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testList() {
		List<BoardVO> list = dao.list();
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Test
	public void testSearch() {
		SearchCriteria cri = new SearchCriteria("title", "AA");
		List<BoardVO> list = dao.search(cri);
		
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Test
	public void testGetSearchAmount() {
		SearchCriteria cri = new SearchCriteria("title", "AA");
		int result = dao.getSearchAmount(cri);
		System.out.println(result+"=============================");
	}

}
