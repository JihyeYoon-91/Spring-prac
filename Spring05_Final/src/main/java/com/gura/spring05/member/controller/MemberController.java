package com.gura.spring05.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.member.dao.MemberDao;
import com.gura.spring05.member.dto.MemberDto;

@Controller
public class MemberController {
	//의존객체 주입받기(DI)
	@Autowired //여러개 일때는 @Reasource(name = "xx" ) 로 구분한다. 이름은(memberdaoimpl에있다.) 
	//@Repository("xx") 이런식으로 부여할 수 있다.
	private MemberDao dao;
	
	//회원목록보기요청(/member/list.do)을 처리할 컨트롤러 메소드 
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		
		List<MemberDto> list=dao.getlist();
		mView.addObject("list",list);
		mView.setViewName("member/list");
		return mView;
	}
	//회원정보 삭제요청처리
	@RequestMapping("/member/delete")
	public String delete(@RequestParam int num) { //@RequestParam은 integer.parseint안해도됌 파라미터 전달은 하나만 가능하다. 여러개를 전달해야한다면 dto로 전달한다.
		//MemberDao객체를 이용해서 회원정보 삭제
		dao.delete(num);
		//리다일렉트 응답
		return "redirect:/member/list.do"; //한번더 list를 요청하게된다.
	}
	
	@RequestMapping("/member/insertform")
	public String insertfrom() {
		//수행할 비즈니스
		return "member/insertform";
	}
	/*
	 *  @ModelAttribute MemberDto dto를 메소드의 인자로 선언하면
	 *  1.폼 전송되는 파라미터가 자동으로 MemberDto 객체에 setter메소드를 통해서
	 *  들어가고 그 객체가 메소드의 인자로 전달된다.
	 *  단, 파라미터명과 Dto의 필드명이 일치해야한다.
	 *  2.파라미터로 전달됐던 내용을 뷰페이지에 키값으로 담아준다.
	 */
	@RequestMapping("/member/insert")
	public ModelAndView insert(@ModelAttribute("dto") MemberDto dto,
			ModelAndView mView){
			dao.insert(dto);
			/*
			 * @ModelAttribute("dto") MemberDto dto의 의미는
			 * 1. 전송되는 파라미터를 자동으로 추출해서 memberDto에 담아주기도하고
			 * 2."dto"라는 키값으로 MemberDto객체를 request영역에 담아주는 역활도한다.
			 */
			//mView.addObject("dto",dto);
			mView.setViewName("member/insert");
			return mView;
	}
		
	
}
