package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InfoController {
    @GetMapping("/info")
    String info(@RequestParam(name = "title",defaultValue = "-") String title,
            @RequestParam(name = "author",defaultValue = "-") String author,
            @RequestParam(name = "venue",defaultValue = "-") String venue,
            @RequestParam(name = "volume",defaultValue = "-") String volume,
            @RequestParam(name = "pages",defaultValue = "-") String pages,
            @RequestParam(name = "year",defaultValue = "-") String year,
            @RequestParam(name = "type",defaultValue = "-") String type,
            @RequestParam(name = "doi",defaultValue = "-") String doi,
            @RequestParam(name = "ee",defaultValue = "-") String ee,
            @RequestParam(name = "key",defaultValue = "-") String key,
            @RequestParam(name = "url",defaultValue = "-") String url,
                Model model) {

        model.addAttribute("title",title);
        model.addAttribute("author",author);
        model.addAttribute("venue",venue);
        model.addAttribute("volume",volume);
        model.addAttribute("pages",pages);
        model.addAttribute("year",year);
        model.addAttribute("type",type);
        model.addAttribute("doi",doi);
        model.addAttribute("ee",ee);
        model.addAttribute("key",key);
        model.addAttribute("url",url);

        return "info";
    }
}
