package by.salon.controller;

import by.salon.entity.News;
import by.salon.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(method= RequestMethod.GET)
    public String getNews(Model model){
        List<News> news = newsService.getFourNews();

        model.addAttribute("newss", news);

        return "news";
    }
}
