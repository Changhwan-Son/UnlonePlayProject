package dto;

import java.util.Date;

public class ArticleDto {

    private String article_title;
    private String article_theme;
    private String article_press;
    private String article_content;
    private String article_image;
    private Date article_crawled_time;
    private Date article_written_time;
    private Date article_modified_time;


    public void setArticle_written_time(Date article_written_time) {
        this.article_written_time = article_written_time;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public void setArticle_theme(String article_theme) {
        this.article_theme = article_theme;
    }

    public void setArticle_press(String article_press) {
        this.article_press = article_press;
    }

    public void setArticle_modified_time(Date article_modified_time) {
        this.article_modified_time = article_modified_time;
    }

    public void setArticle_crawled_time(Date article_crawled_time) {
        this.article_crawled_time = article_crawled_time;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public void setArticle_image(String article_image) {
        this.article_image = article_image;
    }

    public String getArticle_title() {
        return article_title;
    }

    public String getArticle_theme() {
        return article_theme;
    }

    public String getArticle_press(){
        return article_press;
    }

    public String getArticle_image() {
        return article_image;
    }

    public Date getArticle_crawled_time() {
        return article_crawled_time;
    }

    public Date getArticle_modified_time() {
        return article_modified_time;
    }

    public Date getArticle_written_time() {
        return article_written_time;
    }

    public String getArticle_content() {
        return article_content;
    }
}


