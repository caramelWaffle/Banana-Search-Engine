package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.UserInfo;
import com.service.UserInfoService;

@Controller
public class RegisterController  {
	
	@Autowired
	private UserInfoService userInfoService;
	
    @GetMapping("/register")
    String register() {
        return "register";
    }
    
    /**
     * save register info into database
     * @return
     */
    @PostMapping("/registerSave")
    public ModelAndView registerSave(UserInfo userInfo) {
    	//find if exists same user_name
    	ModelAndView mv = new ModelAndView();
    	try {
			if(userInfoService.find(userInfo) !=null){
				mv.setViewName("register");
				mv.addObject("register_msg","username exists");
				return mv;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			mv.setViewName("register");
			mv.addObject("register_msg","error");
			return mv;
		}
    	
    	//user_name not exists ,save into database
    	try {
    		userInfoService.save(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	mv.setViewName("login");
		mv.addObject("register_msg","register successfully");
        return mv;
    }
}
