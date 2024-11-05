package bitcamp.myapp.controller;


import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

// 1번 의존 객체는 무조건 final이 붙어야 한다. 생성자에서 초기화 해야함 --> *롬복이 도와주는 것
//@RequiredArgsConstructor //final이 붙어야 작동
//private final UserService userService;

// 2번
//  @Autowired // final이 없을 경우
//  private UserService userService; //final이 없을 경우에는 이렇게 됨

 // 3번 의존 객체는 무조건 final이 붙어야 한다. 생성자에서 초기화 해야함 --> Afinal이 없는 경우
//  private UserService userService;
//  public AuthController(UserService userService) {
//    this.userService = userService;
//  }

  @Autowired
  private UserService userService;



  @GetMapping("form")
  public void form() {
  }

  @PostMapping("login")
  public String login(
          String email,
          String password,
          boolean saveEmail,
          HttpServletResponse res,
          HttpSession session) throws Exception {

    User user = userService.exists(email, password);
    if (user == null) {
      res.setHeader("Refresh", "2; url=form");
      return "auth/fail";
    }

    if (saveEmail) {
      Cookie cookie = new Cookie("email", email);
      cookie.setMaxAge(60 * 60 * 24 * 7);
      res.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("email", "test@test.com");
      cookie.setMaxAge(0);
      res.addCookie(cookie);
    }

    session.setAttribute("loginUser", user);
    return "redirect:/";
  }

  @GetMapping("logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }

}
