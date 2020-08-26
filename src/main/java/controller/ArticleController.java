package controller;

import model.Article;
import model.Paging;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CrawlingService;

@Controller
public class ArticleController {


    private CrawlingService crawlingService;

    public void setCrawlingService(CrawlingService crawlingService) {
        this.crawlingService = crawlingService;
    }

    @GetMapping("/list")
    public String list(Model model
            , @RequestParam(value = "nowPage", required = false) String nowPage
            , @RequestParam(value = "cntPerPage", required = false) String cntPerPage){

        int total = crawlingService.getTotalRows();
        if(nowPage == null & cntPerPage == null){
            nowPage = "1";
            cntPerPage = "12";
        } else if(nowPage == null){
            nowPage = "1";
        } else if(cntPerPage == null){
            cntPerPage = "12";
        }
        Paging paging = new Paging(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
        model.addAttribute("paging", paging);
        model.addAttribute("viewAll", crawlingService.selectBoard(paging));

        return "article/list";
    }

    @GetMapping("/article")
    public String article(@RequestParam("id") Long id, Model model){
        Article article = crawlingService.getArticleById(id);
        model.addAttribute("article", article);

        return "article/detail";
    }
}
