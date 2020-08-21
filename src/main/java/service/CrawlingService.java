package service;

import dao.ArticleDao;
import dto.ArticleDto;
import model.Article;
import service.crawl.*;

import java.util.ArrayList;
import java.util.List;

public class CrawlingService {

    private ArticleDao articleDao;

    private Chosun chosun = new Chosun();
    private Donga donga = new Donga();
    private Hankyure hankyure = new Hankyure();
    private Joongang joongang = new Joongang();
    private Kyunghyang kyunghyang = new Kyunghyang();
    private Ohmy ohmy = new Ohmy();

    public CrawlingService(ArticleDao articleDao){
        this.articleDao = articleDao;
    }

    public int put(){
        List<Article> articles = new ArrayList<Article>();

        articles.addAll(chosun.crawl());
        articles.addAll(donga.crawl());
        articles.addAll(hankyure.crawl());
        articles.addAll(joongang.crawl());
        articles.addAll(kyunghyang.crawl());
        articles.addAll(ohmy.crawl());



        articleDao.insert(articles);

        return articles.size();
    }
}
