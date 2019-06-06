//package nacs.at.users.ui.controller;
//
//import lombok.RequiredArgsConstructor;
//import nacs.at.users.persistence.domain.UserDto;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/user")
//@RequiredArgsConstructor
//public class SignUpController {
//
//    @ModelAttribute("user")
//    UserDto makeUser(){
//        return new UserDto();
//    }
//
//    @GetMapping
//    String page(){
//        return "signup.component";
//    }
//
//    @GetMapping("signup")
//    public String showSignUpForm(WebRequest request, Model model) {
//        model.addAttribute("user", makeUser());
//        return "signup";
//    }
//
//    public ModelAndView registerUserAccount(
//            @ModelAttribute("user") @Valid UserDto userDto,
//            BindingResult result,
//            WebRequest request,
//            Errors errors) {
//        return null;
//    }
//}
