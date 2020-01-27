package by.salon.controller;

import by.salon.entity.AppUser;
import by.salon.service.UsersListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UsersListController {

    @Autowired
    private UsersListService usersListService;

    @RequestMapping(method = RequestMethod.GET)
    public String getUsersListPage(Model model){

        model.addAttribute("appUsers", usersListService.getAllUsers());

        return "users";
    }

    @RequestMapping("/up/{id}")
    public String upUser(@PathVariable Long id, Model model){

        AppUser appUser = usersListService.getUserById(id);

        if(appUser.getRoleId() != 1){
            appUser.setRoleId(appUser.getRoleId() - 1);
            model.addAttribute("message", "Пользователь успешно повышен.");
            usersListService.upUser(appUser);
        } else{
            model.addAttribute("message", "Пользователь имеет максимальный уровень доступа.");
        }

        model.addAttribute("appUsers", usersListService.getAllUsers());

        return "users";
    }

    @RequestMapping("/down/{id}")
    public String downUser(@PathVariable Long id, Model model){

        AppUser appUser = usersListService.getUserById(id);

        if(appUser.getRoleId() != 3){
            appUser.setRoleId(appUser.getRoleId() + 1);
            model.addAttribute("message", "Пользователь успешно понижен.");
            usersListService.downUser(appUser);
        } else{
            model.addAttribute("message", "Пользователь имеет минимальный уровень доступа.");
        }

        model.addAttribute("appUsers", usersListService.getAllUsers());

        return "users";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model){
        usersListService.deleteUserById(id);
        model.addAttribute("appUsers", usersListService.getAllUsers());
        return "users";
    }
}
