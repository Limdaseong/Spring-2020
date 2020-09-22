package com.koreait.matzip.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.matzip.Const;
import com.koreait.matzip.SecurityUtils;
import com.koreait.matzip.ViewRef;
import com.koreait.matzip.rest.model.RestDMI;
import com.koreait.matzip.rest.model.RestPARAM;

@Controller //handlermapper
@RequestMapping("/rest") // handlermapper에서 첫번째 칸 /
public class RestController {
	
	@Autowired
	private RestService service;

	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String restMap(Model model) {
		model.addAttribute(Const.TITLE, "지도보기");
		model.addAttribute(Const.VIEW, "rest/map");
		
		return ViewRef.TEMP_MENU_TEMP;
	}
	
	@RequestMapping(value="/ajaxGetList", produces = "application/json; charset=utf8") // 마커 인코딩 설정
	@ResponseBody public List<RestDMI> ajaxGetList(RestPARAM param) {
		// 객체를 반환하려면 ResponseBody 필요함
		System.out.println("sw_lat : " + param.getSw_lat());
		System.out.println("sw_lng : " + param.getSw_lng());
		System.out.println("ne_lat : " + param.getNe_lat());
		System.out.println("ne_lng : " + param.getNe_lng());
		return service.selRestList(param);
	}
	
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public String restReg(Model model) {
		model.addAttribute("categoryList", service.selCategoryList());
		model.addAttribute(Const.TITLE, "등록");
		model.addAttribute(Const.VIEW, "rest/reg");
		return ViewRef.TEMP_MENU_TEMP;
	}
	
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String restReg(RestPARAM param, HttpSession hs) {
		param.setI_user(SecurityUtils.getLoginUserPk(hs));
		// 로그인한 사람의 정보를 가져오려면 세션에서 받아오기
		
		int result = service.insRest(param);
		System.out.println(result);
		return "redirect:/rest/map";
	}
	// 새로고침보다는 서버를 껐다가 다시 켜기
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, RestPARAM param) {
		RestDMI data = service.selRest(param);		
		model.addAttribute("data", data);
		model.addAttribute(Const.TITLE, data.getNm());
		model.addAttribute(Const.VIEW, "rest/detail");
		return ViewRef.TEMP_MENU_TEMP;
	}
}
