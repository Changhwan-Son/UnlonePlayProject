package config;

import dao.ArticleDao;
import dao.CommentDao;
import dao.MemberDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import service.AuthService;
import service.CommentService;
import service.CrawlingService;

@Configuration
@EnableTransactionManagement
public class MemberConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/news_db?characterEncoding=utf8");
        ds.setUsername("spring1");
        ds.setPassword("spring1");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setMaxIdle(10);
        ds.setTestWhileIdle(true);
        ds.setMinEvictableIdleTimeMillis(60000 * 3);
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());
        return tm;
    }

    @Bean
    public CommentDao commentDao(){
        return new CommentDao(dataSource());
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

    @Bean
    public ArticleDao articleDao(){
        return new ArticleDao(dataSource());
    }

    @Bean
    public AuthService authService() {
        AuthService authService = new AuthService();
        authService.setMemberDao(memberDao());
        return authService;
    }

    @Bean
    public CrawlingService crawlingService(){
        CrawlingService crawlingService = new CrawlingService(articleDao());
        return crawlingService;
    }

    @Bean
    public CommentService commentService(){
        CommentService commentService = new CommentService(commentDao());
        return commentService;
    }

}
