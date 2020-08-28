package config;

import controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.AuthService;
import service.CommentService;
import service.CrawlingService;
import service.MemberRegisterService;

@Configuration
@ComponentScan({"service"})
public class ControllerConfig {

    @Autowired
    private MemberRegisterService memberRegisterService;

    @Autowired
    private CrawlingService crawlingService;

    @Autowired
    private AuthService authService;

    @Autowired
    private CommentService commentService;

    @Bean
    public HomeController homeController(){
        HomeController homeController = new HomeController();
        homeController.setCrawlingService(crawlingService);
        return homeController;
    }

    @Bean
    public RegisterController registerController() {
        RegisterController controller = new RegisterController();
        controller.setMemberRegisterService(memberRegisterService);
        return controller;
    }

    @Bean
    public LoginController loginController() {
        LoginController controller = new LoginController();
        controller.setAuthService(authService);
        return controller;
    }

    @Bean
    public CrawlController crawlController() {
        CrawlController crawlController = new CrawlController();
        crawlController.setCrawlingService(crawlingService);
        return crawlController;
    }

    @Bean
    public ArticleController articleController(){
        ArticleController articleController = new ArticleController();
        articleController.setCrawlingService(crawlingService);
        articleController.setCommentService(commentService);
        return articleController;
    }


}
