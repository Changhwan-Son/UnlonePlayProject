package dao;

import model.Comment;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CommentDao {

    private JdbcTemplate jdbcTemplate;

    public CommentDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(Comment comment){

        String sql = "insert into COMMENT(article_id, comment_id, comment_content, comment_writer, comment_written_time) values (?,?,?,?,?)";
        int result = jdbcTemplate.update(sql, comment.getArticle_id(), comment.getComment_id(), comment.getComment_content(), comment.getComment_writer(), comment.getComment_written_time());

    }

    public Long getLastComment(Long article_id) {
        String sql = "select count(*) from COMMENT where article_id = " + article_id;
        Long index = jdbcTemplate.queryForObject(sql, Long.TYPE);

        return index;
    }

    public List<Comment> getCommentList(Long article_id) {
        String sql = "select * from COMMENT where article_id = " + article_id;

        List<Comment> list = jdbcTemplate.query(sql, new RowMapper<Comment>() {
            public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
                Comment comment = new Comment();

                comment.setComment_id(rs.getLong("comment_id"));
                comment.setArticle_id(rs.getLong("article_id"));
                comment.setComment_written_time(rs.getDate("comment_written_time"));
                comment.setComment_content(rs.getString("comment_content"));
                comment.setComment_writer(rs.getString("comment_writer"));

                return comment;
            }
        });

        return list;
    }
}
