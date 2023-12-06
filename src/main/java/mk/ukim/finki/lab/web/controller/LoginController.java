package mk.ukim.finki.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.lab.model.User;
import mk.ukim.finki.lab.service.LoginService;
import mk.ukim.finki.lab.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.lab.model.exceptions.InvalidArgumentsException;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;

        try {
            user = loginService.login(request.getParameter("username"), request.getParameter("password"));
        } catch (InvalidUserCredentialsException | InvalidArgumentsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }

        request.getSession().setAttribute("user", user);
        return "redirect:/movies";
    }

}
