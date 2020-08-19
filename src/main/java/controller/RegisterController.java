package controller;

import dto.RegisterRequest;
import exception.DuplicateMemberException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.MemberRegisterService;

@Controller
public class RegisterController {


    private MemberRegisterService memberRegisterService;


    public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    @GetMapping("/register")
    public String registerForm(){
        return "register/registerForm";
    }

    @PostMapping("/registerSuccess")
    public String register(RegisterRequest regReq) {
        try {
            memberRegisterService.regist(regReq);
            return "register/registerSuccess";
        }catch(DuplicateMemberException ex) {
            return "register/registerForm";
        }
    }



}
