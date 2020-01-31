package com.gura.spring05;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
 *  @Controller 어노테이션
 *  -해당 클래스가 Spring MVC프로젝트에서 Controller가 될 수 있도록 한다.
 *  -component scan을 통해서 spring bean container에서 관리가 되는
 *   bean이 되어야 동작을 한다.
 * 
 */
@Controller
public class HomeController {	
	
	//home.do요청이 왔을 때 요청을 처리하게 하는 @ReaquestMapping 어노테이션
	@RequestMapping("/home.do")
	public String home(HttpServletRequest request) {
			//모델
			List<String> notice=new ArrayList<>();
			notice.add("감기조심");
			notice.add("코로나 조심");
			notice.add("다들 살아 남아요");
			notice.add("어쩌구..");
			notice.add("저쩌구..");
			
			//모델을 request에 담는다.
			request.setAttribute("notice", notice);
		/*
		 *  "home"을 리턴해주면 
		 *  
		 *  "/WEB-INF/views/"+"home"+".jsp"와 같은 문자열이 만들어 지고
		 *  
		 *   /WEB-INF/views/home.jsp페이지로 forward 이동 되어서
		 *   
		 *   응답된다.
		 */
		return "home";
	}	
	@RequestMapping("/play")
	public ModelAndView play(HttpSession session,
			ModelAndView mView) {
		//세션에 로그인 정보가 있는지 확인한다.
		String id=(String)session.getAttribute("id");
		if(id==null) {//로그인이 되지 않은상태
			//로그인 폼으로 리다일렉트 시킨다.
			mView.setViewName("redirect:/users/loginForm.do");
		}else {//로그인이 된 상태
			//forward이동해서 응답한다.
			mView.setViewName("play");
			
		}
		return mView;
	}
}
