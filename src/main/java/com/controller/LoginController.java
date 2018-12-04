package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SecurityConfig;
import com.service.UserInfoService;

@Controller
public class LoginController {
	
	@Autowired
	private UserInfoService userInfoService;
	
    @GetMapping("/login")
    String login() {
        return "login";
    }
    
    @PostMapping("/loginverify")
    ModelAndView loginverify(String username, String password, HttpSession session) {
    	try {
			if(!userInfoService.checkLogin(username, password)){
				ModelAndView mv = new ModelAndView("/login");
				mv.addObject("msg","incorrect username or password");
				return mv;
			}
	        session.setAttribute(SecurityConfig.SESSION_KEY, username);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	ModelAndView mv = new ModelAndView("/index");
        return mv;
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // remove session
        session.removeAttribute(SecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}
