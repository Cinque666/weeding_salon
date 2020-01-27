package by.salon.controller;

import by.salon.entity.FeedBack;
import by.salon.service.FeedBackFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/feedBackForm")
public class FeedBackFormController {

    @Autowired
    private FeedBackFormService feedBackFormService;
    private static final String REGEX = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";

    @RequestMapping(method = RequestMethod.GET)
    public String getFeedBackFormController(Model model){
        return "feedBackForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postFeedBackFormController(@ModelAttribute FeedBack feedBack, Model model){

        if(feedBack.getEmail().matches(REGEX)) {
            feedBackFormService.add(feedBack);
        } else return "home";

        return "feedBackForm";
    }
}
