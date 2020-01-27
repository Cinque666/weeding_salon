package by.salon.service;

import by.salon.entity.News;
import by.salon.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Transactional
    public List<News> getFourNews(){
        return newsRepository.getFourNews();
    }
}
