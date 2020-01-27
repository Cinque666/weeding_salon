package by.salon.controller;

import by.salon.entity.AppUser;
import by.salon.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(method = RequestMethod.GET)
    public String getRegistrationPage(Model model){
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String signUpUser(@ModelAttribute AppUser appUser, Model model){

        appUser.setRoleId(3);

        if(registrationService.signUpUser(appUser)){
            model.addAttribute("message", "Регистрация прошла успешно!");
        } else{
            model.addAttribute("message", "Ошибка.Что-то пошло не так");
        }
        return "registration";
    }
}
