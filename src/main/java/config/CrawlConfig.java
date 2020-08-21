package config;

import dao.ArticleDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import service.CrawlingService;
import service.crawl.Chosun;

@Configuration
@EnableTransactionManagement
public class CrawlConfig {

    public Chosun chosun(){
        return new Chosun();
    }


}
