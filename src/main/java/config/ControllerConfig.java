package config;

import controller.HomeController;
import controller.LoginController;
import controller.RegisterController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.AuthService;
import service.MemberRegisterService;

@Configuration
@ComponentScan({"service"})
public class ControllerConfig {

    @Autowired
    private MemberRegisterService memberRegisterService;

    @Autowired
    private AuthService authService;

    @Bean
    public HomeController homeController(){
        HomeController homeController = new HomeController();
        return homeController;
    }

    @Bean
    public RegisterController registerController() {
        RegisterController controller = new RegisterController();
        controller.setMemberRegisterService(memberRegisterService);
        return controller;
    }

    @Bean
    public LoginController loginController() {
        LoginController controller = new LoginController();
        controller.setAuthService(authService);
        return controller;
    }


}
