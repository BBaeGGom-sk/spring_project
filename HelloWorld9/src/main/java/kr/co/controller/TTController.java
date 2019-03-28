package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.domain.TTDTO;
import kr.co.service.TTService;

@Controller
@RequestMapping("/tt")
public class TTController {
	
	@Inject
	private TTService service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<TTDTO> list= service.list();
		model.addAttribute("list", list);
		return "tt/list";
	}
	
	@RequestMapping("/insertui")
	public String insertui() {
		return "tt/insert";
	} 
	
	@RequestMapping("/insert")
	public String insert(TTDTO dto,Model model) {
		
		service.insert(dto);
		model.addAttribute("dto", dto);
		
		return "redirect:/tt/list";
	}
	
	@RequestMapping("/selectbyid")
	public String selectbyid(int num,Model model) {
		
		TTDTO dto = service.selectbyid(num);
		model.addAttribute("dto",dto);
		
		return "tt/selectbyid";
	}

}
