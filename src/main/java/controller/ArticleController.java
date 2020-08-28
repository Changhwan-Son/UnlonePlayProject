package controller;

import model.Article;
import model.Comment;
import model.Paging;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.CommentService;
import service.CrawlingService;

import java.util.Date;
import java.util.List;

@Controller
public class ArticleController {


    private CrawlingService crawlingService;
    private CommentService commentService;

    public void setCrawlingService(CrawlingService crawlingService) {
        this.crawlingService = crawlingService;
    }
    public void setCommentService(CommentService commentService){this.commentService = commentService;}

    @GetMapping("/list")
    public String list(Model model
            , @RequestParam(value = "nowPage", required = false) String nowPage){

        int total = crawlingService.getTotalRows();
        if(nowPage == null ) {
            nowPage = "1";
        }
        Paging paging = new Paging(total, Integer.parseInt(nowPage));
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


    @PostMapping(value="/newComment",  consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, // 컨트롤러가 클라이언트로 부터 받는 데이터의 타입
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE) // 컨트롤러가 클라이언트에게 전송하는 데이터의 타입)
    @ResponseBody
    public Comment newComment(@RequestBody Comment comment){
        Long id = commentService.insert(comment);
        return comment;
    }

    @RequestMapping(value = "/commentList/{article_id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Comment> commentList(@PathVariable("article_id") Long article_id){
        List<Comment> list = commentService.getCommentList(article_id);

        return list;
    }




}
