package service;

import dao.MemberDao;
import dto.RegisterRequest;
import exception.DuplicateMemberException;
import model.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberRegisterService {

    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public Long regist(RegisterRequest req) {
        Member member = memberDao.selectByName(req.getName());

        if(member != null) {
            throw new DuplicateMemberException("dup name" + req.getName());
        }
        // 같은 이름을 가진 회원이 존재하지 않으면 DB에 삽입
        Member newMember = new Member(req.getName(), req.getPassword());
        memberDao.insert(newMember);
        return newMember.getMember_id();
    }

}
