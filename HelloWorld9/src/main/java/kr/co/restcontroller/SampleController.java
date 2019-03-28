package kr.co.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.BoardVO;

@RestController /* 제이슨을 지원하는 컨트롤러 */
@RequestMapping("/sample")
public class SampleController {

	@RequestMapping("/hello") //jsp주소가 아니라 바로 출력
	public String hello() {
		return "Hello, everyone";
	}
	
	@RequestMapping("/sendvo") //VO tosring처럼 출력
	public BoardVO sendVO() {
		BoardVO vo = new BoardVO(1, "1", "1", "1", null, null, 0);
		return vo;
	}
	
	@RequestMapping("/sendlist") //list 하나하나 화면단 출력
	public List<BoardVO> sendList() {
		List<BoardVO> list = new ArrayList<BoardVO>();

		for(int i=0; i<10; i++) {
			BoardVO vo = new BoardVO(i, "a"+i, "a"+i, "a"+i, null, null, i);
			
			list.add(vo);
		}
		
		return list;
	}
	
	@RequestMapping("/sendmap") // map 하나하나 출력
	public Map<Integer, BoardVO> sendMap() {
		Map<Integer, BoardVO> map = new HashMap<Integer, BoardVO>();
		
		for(int i=0; i<10; i++) {
			BoardVO vo = new BoardVO(i, "a"+i, "a"+i, "a"+i, null, null, i);
			
			map.put(i, vo);
		}
		
		return map;
	}
	
	@RequestMapping("/senderror") // 연결이 잘 되어도 일부러 에러창 뜨게 조작하기 ResponseEntity를 이용 !!
	public ResponseEntity<Void> senderr() {
		
		return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
	}
	
	@RequestMapping("/sendlistnot") // 연결이 되어 데이터는 보이지만 네트워크쪽에는 에러가 뜬것처럼 조작하기 ResponseEntity를 이용 !!
	public ResponseEntity<List<BoardVO>> sendlistnot() {
		List<BoardVO> list = new ArrayList<BoardVO>();

		for(int i=0; i<10; i++) {
			BoardVO vo = new BoardVO(i, "a"+i, "a"+i, "a"+i, null, null, i);
			
			list.add(vo);
		}
		
		return new ResponseEntity<List<BoardVO>>(list,HttpStatus.NOT_FOUND);
	}
}
