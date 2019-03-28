package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.ReplyVO;
import kr.co.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Inject
	private ReplyService service;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> insert(@RequestBody ReplyVO vo) {

		ResponseEntity<String> entity = null;

		try { // 성공할지 , 실패할지 모르기때문
			service.insert(vo);
			entity = new ResponseEntity<String>("INSERT_SUCCES", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;

	}

	@RequestMapping(value = "/{bno}", method = RequestMethod.GET) // bno를 동적으로 넘겨받는방법 패스정보일때는 이렇게 사용
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") int bno) {

		ResponseEntity<List<ReplyVO>> entity = null;

		try {
			List<ReplyVO> list = service.list(bno);

			entity = new ResponseEntity<List<ReplyVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value="/{rno}",method=RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("rno")int rno,@RequestBody ReplyVO vo) {
		
		ResponseEntity<String> entity = null;
		
		try {
			vo.setRno(rno);
			service.update(vo);
			
			entity = new ResponseEntity<String>("UPDATE_SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{rno}",method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("rno")int rno) {
		
		ResponseEntity<String> entity = null;
		
		try {
			service.delete(rno);
			
			entity = new ResponseEntity<String>("DELETE_SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
}
