package service;

import dao.ArticleDao;
import dto.ArticleDto;
import model.Article;
import model.Paging;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import service.crawl.*;

import java.util.ArrayList;
import java.util.List;

@EnableScheduling
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

    @Scheduled(fixedDelay = 3600000)
    public void put(){
        List<Article> articles = new ArrayList<Article>();

        articles.addAll(chosun.crawl());
        articles.addAll(donga.crawl());
        articles.addAll(hankyure.crawl());
        articles.addAll(joongang.crawl());
        //articles.addAll(kyunghyang.crawl());
        articles.addAll(ohmy.crawl());


        System.out.println("scheduler ");
        articleDao.insert(articles);


    }

    public List<Article> getLatestArticles(){
        List<Article> articles = new ArrayList<Article>();
        articles = articleDao.selectLatest();

        return articles;
    }

    public int getTotalRows(){
        int count = 0 ;
        count = articleDao.selectTotalRows();

        return count;
    }

    public Article getArticleById(Long id){
        Article article = articleDao.selecyById(id);
        return article;
    }

    public List<Article> selectBoard(Paging paging){

        List<Article> articles = articleDao.selectBoard(paging.getStart(), paging.getEnd());
        return articles;
    }

}
