package com.traiyi.service.impl;

import com.traiyi.mapper.QuestionAnswerMapper;
import com.traiyi.pojo.QuestionAnswer;
import com.traiyi.pojo.SelectCondition;
import com.traiyi.service.QuestionAnswerService;
import com.traiyi.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
    @Autowired
    QuestionAnswerMapper questionAnswerMapper;


    public List<QuestionAnswer> list() {
        List<QuestionAnswer> list = questionAnswerMapper.list();
        for (QuestionAnswer q : list
        ) {
            System.out.println(q);
        }


        return questionAnswerMapper.list();
    }


    @Override
    public List<QuestionAnswer> list(SelectCondition selectCondition) {
        // TODO Auto-generated method stub
        return questionAnswerMapper.list(selectCondition);
    }


    @Override
    public int total() {
        return questionAnswerMapper.total();
    }


    @Override
    public int add(QuestionAnswer c) {
        return questionAnswerMapper.add(c);

    }


    @Override
    public int update(QuestionAnswer c) {
        return questionAnswerMapper.update(c);
    }


    @Override
    public int delete(int id) {
        return questionAnswerMapper.delete(id);
    }


    @Override
    public QuestionAnswer get(int id) {
        // TODO Auto-generated method stub
        return questionAnswerMapper.get(id);
    }

    ;


}
