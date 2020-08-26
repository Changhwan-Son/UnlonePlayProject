package dao;

import model.Article;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public List<Article> selectLatest(){
        String sql = "select * from (select  * from ARTICLE ORDER BY article_id desc limit 12)  as a ORDER BY article_id asc";
        List<Article> articles = jdbcTemplate.query(sql, new RowMapper<Article>() {
            public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
                Article article = new Article();

                article.setArticle_title(rs.getString("article_title"));
                article.setArticle_content(rs.getString("article_content"));
                article.setArticle_image(rs.getString("article_image"));
                article.setArticle_press(rs.getString("article_press"));
                article.setArticle_theme(rs.getString("article_theme"));
                article.setArticle_url(rs.getString("article_url"));
                article.setArticle_crawled_time(rs.getDate("article_crawled_time"));
                article.setArticle_written_time(rs.getDate("article_written_time"));
                article.setArticle_modified_time(rs.getDate("article_modified_time"));
                article.setArticle_id(rs.getLong("article_id"));

                return article;
            }
        });

        return articles;
    }

    public int selectTotalRows() {
        int count = 0;

        String sql = "SELECT COUNT(article_id) FROM ARTICLE";
        count = jdbcTemplate.queryForObject(sql, Integer.TYPE);

        return count;
    }

    public Article selecyById(Long id){
        String sql = "SELECT * FROM ARTICLE WHERE article_id = " + id;

        List<Article> articles = jdbcTemplate.query(sql, new RowMapper<Article>() {
            public Article
            mapRow(ResultSet rs, int rowNum) throws SQLException {
                Article article = new Article();

                article.setArticle_title(rs.getString("article_title"));
                article.setArticle_content(rs.getString("article_content"));
                article.setArticle_image(rs.getString("article_image"));
                article.setArticle_press(rs.getString("article_press"));
                article.setArticle_theme(rs.getString("article_theme"));
                article.setArticle_url(rs.getString("article_url"));
                article.setArticle_crawled_time(rs.getDate("article_crawled_time"));
                article.setArticle_written_time(rs.getDate("article_written_time"));
                article.setArticle_modified_time(rs.getDate("article_modified_time"));
                article.setArticle_id(rs.getLong("article_id"));

                return article;
            }
        });
        return articles.get(0);
    }

    public List<Article> selectBoard(int start, int end){
        String sql = "select * from (select @ROWNUM  := @ROWNUM + 1 AS RN, A.* from (select * from ARTICLE ORDER BY article_id desc) A ) B WHERE RN BETWEEN " + start + " AND " + end;
        List<Article> articles = jdbcTemplate.query(sql, new RowMapper<Article>() {
            public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
                Article article = new Article();

                article.setArticle_title(rs.getString("article_title"));
                article.setArticle_content(rs.getString("article_content"));
                article.setArticle_image(rs.getString("article_image"));
                article.setArticle_press(rs.getString("article_press"));
                article.setArticle_theme(rs.getString("article_theme"));
                article.setArticle_url(rs.getString("article_url"));
                article.setArticle_crawled_time(rs.getDate("article_crawled_time"));
                article.setArticle_written_time(rs.getDate("article_written_time"));
                article.setArticle_modified_time(rs.getDate("article_modified_time"));
                article.setArticle_id(rs.getLong("article_id"));

                return article;
            }
        });

        return articles;
    }

}
