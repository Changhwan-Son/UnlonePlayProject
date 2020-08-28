package service;

import dao.CommentDao;
import model.Comment;

import java.util.Date;
import java.util.List;

public class CommentService {
    private CommentDao commentDao;

    public CommentService(CommentDao commentDao){
        this.commentDao = commentDao;
    }

    public Long insert(Comment comment){
        comment.setComment_written_time(new Date());
        comment.setComment_id(commentDao.getLastComment(comment.getArticle_id()) + 1);

        commentDao.insert(comment);
        return comment.getComment_id();
    }


    public List<Comment> getCommentList(Long article_id){
        List<Comment> list = commentDao.getCommentList(article_id);
        return list;
    }


}
