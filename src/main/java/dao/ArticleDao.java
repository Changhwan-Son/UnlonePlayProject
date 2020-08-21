package dao;

import model.Article;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ArticleDao {

    private JdbcTemplate jdbcTemplate;

    public ArticleDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(List<Article> articles){

        String sql = "insert into ARTICLE(article_press, article_title, article_content, article_image, article_theme, article_url,article_written_time, article_modified_time, article_crawled_time) values(?,?,?,?,?,?,?,?,?)";
        for(Article article : articles) {
            int result = jdbcTemplate.update(sql, article.getArticle_press(), article.getArticle_title(), article.getArticle_content(), article.getArticle_image(), article.getArticle_theme(),
                    article.getArticle_url(),article.getArticle_written_time(), article.getArticle_modified_time(), article.getArticle_crawled_time());
        }
    }

}
