package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    String index() {
        return "index";
    }

//    @GetMapping("/index")
//    String hello(@RequestParam(name = "q", required = false, defaultValue = "") String name, Model model) {
//        model.addAttribute("keyword", name);
//        if (!name.equals("")){
//            DBLResult dblResult = callRestApi(name);
//            model.addAttribute("results", dblResult.getResult().getHits()
//                    .getHit());
//        }
//        return "index";
//    }
//
//    private DBLResult callRestApi(String name) {
//        String url = "http://dblp.org/search/publ/api?q="+name+"&format=json";
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(url, DBLResult.class);
//    }
}
