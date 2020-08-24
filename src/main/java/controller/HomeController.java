package controller;

import dto.ArticleDto;
import model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.CrawlingService;
import service.crawl.Chosun;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private CrawlingService crawlingService;

    public void setCrawlingService(CrawlingService crawlingService) {
        this.crawlingService = crawlingService;
    }

    @GetMapping("/")
    public String home(Model model){

        // crawlingService.put();

        List<Article> articles = crawlingService.getLatestArticles();
        model.addAttribute("articles", articles);
        return "index";
    }




}



