package by.salon.service;

import by.salon.entity.FeedBack;
import by.salon.repository.FeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FeedBackFormService {

    @Autowired
    private FeedBackRepository feedBackRepository;


    @Transactional
    public void add(FeedBack feedBack) {
        feedBackRepository.add(feedBack);
    }
}
