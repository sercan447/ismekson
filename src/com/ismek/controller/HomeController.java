package com.ismek.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String hello() {
		
		return "merhaba";
	}
	
	
	@RequestMapping(value="/giris",method=RequestMethod.GET)
	public String giris() {
		
		return "giris";
	}
	
	@RequestMapping("/hata")
	public ModelAndView hata(Principal principal) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("hata");
		
		if(principal != null) {
			view.addObject("msg",principal.getName()+",Bu Web servisine eriþiminiz Bulunmamaktadýr.");
		}else {
			view.addObject("msg","Bu Servise eriþemezsiniz");
		}
		return view;
	}
	
}
