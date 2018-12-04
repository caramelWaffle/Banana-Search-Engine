package com.caramelwaffle.literature.controller;

import com.caramelwaffle.literature.model.dbl.DBLResult;
import com.caramelwaffle.literature.recommendation.CollaborativeFiltering;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class ResultController {
    @GetMapping("/result")
    String result(@RequestParam(name = "q", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("keyword", name);
        if (!name.equals("")){
            DBLResult dblResult = callRestApi(name);
            createRecommendation(dblResult);
            model.addAttribute("results", dblResult.getResult().getHits()
                    .getHit());
        }
        return "result";
    }

    private void createRecommendation(DBLResult dblResult) {
        String currentUserId = "getUserId";
        CollaborativeFiltering filtering = new CollaborativeFiltering();
        filtering.setDataset(dblResult.getResult());
        filtering.setRecommendationToUser(currentUserId);
    }

    private DBLResult callRestApi(String name) {
        String url = "http://dblp.org/search/publ/api?q="+name+"&format=json";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, DBLResult.class);
    }
}
