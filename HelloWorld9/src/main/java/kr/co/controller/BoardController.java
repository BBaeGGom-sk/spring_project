package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.BoardVO;
import kr.co.domain.Criteria;
import kr.co.domain.SearchCriteria;
import kr.co.domain.pageMaker;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Inject
	private BoardService service;
	
	@RequestMapping("/list")
	public String list(Criteria cri,Model model) {
		
		List<BoardVO> list = service.listpage(cri);
		int amount = service.getAmount();
		
		pageMaker pm = new pageMaker(amount,cri);
		model.addAttribute("pm",pm);
		
		model.addAttribute("list",list);
		
		return "board/list";
	}
	
	/*
	 * @RequestMapping("/list") public String list(Model model) {
	 * 
	 * List<BoardVO> list = service.list(); model.addAttribute("list",list);
	 * 
	 * return "board/list"; }
	 */
	
	@RequestMapping(value="/insertui", method=RequestMethod.GET)
	public String insertUI() {
		
		return "board/insert"; // 리다이렉트가 없으면 jsp로 바로 쏴라
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(BoardVO vo) {
		
		service.insert(vo);
		return "redirect:/board/list"; // 컨트롤러를 무조건 거쳐라 => 리다이렉트
	}
	
	@RequestMapping("/selectbybno")
	public String selectbybno(int bno,Model model,Criteria cri) {
		
		BoardVO vo = service.selectbybno(bno);
		model.addAttribute("vo",vo);
		model.addAttribute("cri",cri);
		

		return "board/selectbybno";
	}
	
	@RequestMapping("/update")
	public String updateui(int bno,Model model,@ModelAttribute("cri") Criteria cri) {
	
		BoardVO vo = service.updateui(bno);
		model.addAttribute("vo",vo);
		
		return "board/update";
	}
	
	@RequestMapping("/delete")
	public String delete(int bno,Criteria cri,Model model) {
		
		service.delete(bno);
		model.addAttribute("page",cri.getPage());
		model.addAttribute("perpage",cri.getPerpage());
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(BoardVO vo,Criteria cri,Model model) {
		
		service.update(vo);
		model.addAttribute("page",cri.getPage());
		model.addAttribute("perpage",cri.getPerpage());
		return "redirect:/board/list";
	}
	
	@RequestMapping("/listpage") // 페이징 처리
	public String listpage(Criteria cri, Model model) {
		
		List<BoardVO> list = service.listpage(cri);
		model.addAttribute("list",list);
		return "board/list";
	}
	
	@RequestMapping("/search") //검색 기능
	public String search(SearchCriteria cri,Model model) {
		
		//페이징처리 시작
		List<BoardVO> list = service.serach(cri);
		model.addAttribute("list",list);
		
		int amount = service.getSearchAmount(cri);
		
		pageMaker pm = new pageMaker(amount, cri);
		pm.setCri(cri);
		
		model.addAttribute("pm", pm);
		//페이징처리 끝
		
		return "/board/search";
	}
	
	@RequestMapping("/s_selectbybno")
	public String s_selectbybno(int bno,Model model,SearchCriteria cri) {
		
		BoardVO vo = service.selectbybno(bno);
		model.addAttribute("vo",vo);
		model.addAttribute("cri",cri);
		
		return "/board/s_selectbybno";
	}
	
	@RequestMapping("/s_update")
	public String s_updateui(int bno,Model model,@ModelAttribute("cri") SearchCriteria cri) {
	
		BoardVO vo = service.updateui(bno);
		model.addAttribute("vo",vo);
		
		return "board/s_update";
	}
	
	@RequestMapping("/s_delete")
	public String s_delete(int bno,SearchCriteria cri,Model model,RedirectAttributes rttr) {
		
		service.delete(bno);
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perpage", cri.getPerpage());
		return "redirect:/board/search";
	}
	
	@RequestMapping(value="/s_update", method=RequestMethod.POST)
	public String s_update(BoardVO vo,SearchCriteria cri,Model model) {
		
		service.update(vo);
		model.addAttribute("page",cri.getPage());
		model.addAttribute("perpage",cri.getPerpage());
		model.addAttribute("searchType", cri.getSearchType());
		model.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/search";
	}
}
