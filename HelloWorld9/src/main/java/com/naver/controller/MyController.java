package com.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.MemberDTO;

@Controller
public class MyController {

	@RequestMapping("/doA")
	public void doA() {  //doA로 넘어갈때 시스아웃찍기
		System.out.println("doA().................");
	}
	
	@RequestMapping("/doB")
	public void doB(MemberDTO dto) {  //doB?로 dto데이터값넘겨서 나오는지 보기
		System.out.println(dto);
	}
	
	@RequestMapping("/doC")
	public void doC(int id,String name,int age) { //doC?id= 이런식으로 콘솔에 보기
		System.out.println(id);
		System.out.println(name);
		System.out.println(age);
	}
	
	@RequestMapping("/doD")
	public String doD() { //jsp파일 만들어서 넘어가는지 보기
		System.out.println("doD...........");
		
		return "doD";
	}
	
	@RequestMapping("/doE")
	public String doE(Model model) { //어트리뷰트로 값 넘겨보기
		
		model.addAttribute("test", "test");
		
		return "doE";
	}
	
	@RequestMapping("/doF")
	public String doF() { //리다이렉트 형식으로 다른페이지로 넘어가보기
		System.out.println("doF()..................");
		return "redirect:/doG";
	}
	
	@RequestMapping("/doG")
	public String doG() { //리다이렉트로 넘어오는지 보기
		System.out.println("doG()..................");
		return "doG";
	}
	
	@RequestMapping("doH")
	public String doH(Model model) { //리다이렉트로 값 넘겨보기
		model.addAttribute("show", "show");
		return "redirect:/doI";
	}
	
	@RequestMapping("doI")
	public String doI(String show) { //리다이렉트로 값 넘어오는지 보기 (안옴)
		System.out.println(show);
		return "doI";
	}
	
	@RequestMapping("/doJ")
	public String doJ(Model model) { //리다이렉트로 값 넘겨보기
		System.out.println("doJ()...........");
		model.addAttribute("newK", "new");
		return "redirect:/doK";
	}
	
	@RequestMapping("/doK")
	public String doK(String newK,Model model) { // 모델을 통해 리다이렉트여도 받은값
		System.out.println(newK);				// 값을 받아올 수 있음
		model.addAttribute("newK", newK);
		return "doK";
	}
	
	@RequestMapping("/doL")
	public String doL(Model model) { // 리다이렉트로 값 넘기기
		model.addAttribute("simple", "simple");
		return "redirect:/doM";
	}
	
	@RequestMapping("/doM")
	public String doM(@ModelAttribute("simple") String simple) {
		//모델어트리뷰트를 위와같이 이용하면 애드어트리뷰트를 쓰지않아도 뷰까지 바로 전달가능함
		System.out.println(simple); //하지만 모델어트리뷰트는 주소창에 겟방식처럼
									//정보노출이 일어남
		return "doM";
	}
	
	@RequestMapping("/doO")
	public String doO(RedirectAttributes rtts) { //리다이렉트어트리뷰트로 값넘기기
		rtts.addFlashAttribute("rttr", "rttr");
		//리다이렉트어트리뷰트를 사용하면 url에 정보 노출을 막을 수 있음
		return "redirect:/doP";
	}
	
	@RequestMapping("/doP")
	public String doP(@ModelAttribute("rttr") String rttr) {
		// 뷰로 바로 받기 위해 모델 어트리뷰트 사용?(안해도 뷰로 가지긴함)
		return "doP";
	}
	
	@RequestMapping("/doQ")
	public @ResponseBody MemberDTO doQ() {
		MemberDTO dto = new MemberDTO(1, "kk", 22);
		// jsp를 만들지 않아도 toString같은 형식을 바로 화면에 출력해줌
		return dto;
	}
	
	@RequestMapping("/doR")
	public void doR(@RequestParam int num) {
		//리퀘스트파람은 안써도 가능하지만 전버전인 3버전에서는 무조건 써줘야 가능했음
		System.out.println(num);
	}
	
	@RequestMapping("/doS")
	public ModelAndView doS() {
		//모델앤뷰는 예전에 사용했던것 url에 /doS로 연결시 sorry라는 jsp로 넘어간다
		ModelAndView mav= new ModelAndView();
		mav.addObject("str", "This train is for Sindorim");
		mav.setViewName("sorry");
		
		return mav;
		
	}
	
}
