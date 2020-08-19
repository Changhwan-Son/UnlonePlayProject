package model;

public class Member {

    private Long member_id;
    private String member_name;
    private String member_password;


    public Member(String member_name, String member_password){
        this.member_name = member_name;
        this.member_password = member_password;
    }
    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public Long getMember_id(){
        return member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public String getMember_password() {
        return member_password;
    }


    public boolean matchPassword(String password) {
        return this.member_password.equals(password);
    }

}
