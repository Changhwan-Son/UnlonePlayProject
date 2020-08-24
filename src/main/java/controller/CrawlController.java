package controller;

import model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import service.CrawlingService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CrawlController {

    private CrawlingService crawlingService;

    public void setCrawlingService(CrawlingService crawlingService) {
        this.crawlingService = crawlingService;
    }


    @GetMapping("/getLatestArticles")
    public List<Article> latestArticles(){
        List<Article> articles = new ArrayList<Article>();
        articles = crawlingService.getLatestArticles();

        return articles;
    }
}
