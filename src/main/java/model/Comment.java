package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {

    private Long article_id;
    private Long comment_id;
    private String comment_writer;
    private String comment_content;
    private Date comment_written_time;

    SimpleDateFormat fm = new SimpleDateFormat("yyyy.MM.dd hh:mm");



    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
    }

    public Long getArticle_id() {
        return article_id;
    }

    public Date getComment_written_time() {
        return comment_written_time;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public String getComment_writer() {
        return comment_writer;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public void setComment_writer(String comment_writer) {
        this.comment_writer = comment_writer;
    }

    public void setComment_written_time(Date comment_written_time) {
        this.comment_written_time = comment_written_time;
    }
}
