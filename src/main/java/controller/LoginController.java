package controller;

import dto.LoginRequest;
import dto.LoginRequestValidator;
import exception.WrongIdPasswordException;
import model.AuthInfo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AuthService;
import service.CrawlingService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private AuthService authService;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String form(LoginRequest loginRequest) {

        return "login/loginForm";
    }

    @PostMapping("/login")
    public String submit(LoginRequest loginRequest, Errors errors, HttpSession session) {
        new LoginRequestValidator().validate(loginRequest,  errors);
        if(errors.hasErrors()) {
            return "login/loginForm";
        }
        try {
            AuthInfo authInfo = authService.authenticate(
                    loginRequest.getName(),
                    loginRequest.getPassword());

            session.setAttribute("authInfo", authInfo);

            //  TODO 세션에 authInfo 저장해야 함
            return "index";
        } catch(WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";
        }

    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}
