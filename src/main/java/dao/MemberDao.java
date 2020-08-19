package dao;

import model.Member;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectByName(String name){
        List<Member> results = jdbcTemplate.query(
                "select * from MEMBER where member_name = ?",
                new RowMapper<Member>() {
                    public Member mapRow(ResultSet rs, int rowNnum)
                            throws SQLException {
                        Member member = new Member(
                                rs.getString("MEMBER_NAME"),
                                rs.getString("MEMBER_PASSWORD"));
                        member.setMember_id(rs.getLong("MEMBER_ID"));
                        return member;
                    }
                },
                name);

        return results.isEmpty() ? null : results.get(0);
    }


    public void insert(final Member member){
        String sql = "insert into MEMBER(member_name, member_password) values(?,?)";
        int result = jdbcTemplate.update(sql, member.getMember_name(), member.getMember_password());
        System.out.println("insert 성공");
    }


}
