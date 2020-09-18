package com.koreait.matzip.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.matzip.Const;
import com.koreait.matzip.ViewRef;
import com.koreait.matzip.user.model.UserDTO;
import com.koreait.matzip.user.model.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired // 각 상황의 타입에 맞는 IoC컨테이너 안에 존재하는 객체화된 Bean을 자동으로 주입해 줌
						// 단 하나만 등록이 돼있어야함
	private UserService service;

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute(Const.TITLE, "로그인");
		model.addAttribute(Const.VIEW, "user/login");
		return ViewRef.TEMP_DEFAULT; // ViewResolver (서블릿 -> jsp)
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(UserDTO param) {
		int result = service.login(param);
		
		if(result == 1) {
			return "redirect:/rest/map"; // response.sendRedirect() 서블릿 
			// --> 서블릿(rest/map GET메소드로 감)
		}
		
		return "redirect:/user/login?err=" + result;
	}
	
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String join(Model model, @RequestParam(defaultValue="0") Integer err) {
		// join() 파라미터 안에 ,찍고 @RequestParam() 안에
		System.out.println("err : " + err);
		
		if(err > 0) {
			model.addAttribute("msg", "에러가 발생하였습니다.");
		}
		
		model.addAttribute(Const.TITLE, "회원가입");
		model.addAttribute(Const.VIEW, "user/join");
		return ViewRef.TEMP_DEFAULT;
	}
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String join(UserVO param) {
		int result = service.join(param);
		
		if(result == 1) {
			return "redirect:/user/login";
		}
		
		return "redirect:/user/join?err=" + result;
	}
	
	
}
