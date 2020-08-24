package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {


    @GetMapping("/list")
    public String list(Model model){
        return "article/list";
    }
}
