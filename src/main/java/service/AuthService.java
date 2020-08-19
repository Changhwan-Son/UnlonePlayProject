package service;

import dao.MemberDao;
import exception.WrongIdPasswordException;
import model.AuthInfo;
import model.Member;

public class AuthService {

    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public AuthInfo authenticate(String name, String password) {
        Member member = memberDao.selectByName(name);
        if(member == null) {
            throw new WrongIdPasswordException();
        }
        if(!member.matchPassword(password)) {
            throw new WrongIdPasswordException();
        }
        return new AuthInfo(member.getMember_id(), member.getMember_name());
    }
}
