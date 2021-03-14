package com.lzc.service.impl;

import com.lzc.mapper.QuestionAnswerMapper;
import com.lzc.pojo.QuestionAnswer;
import com.lzc.pojo.SelectCondition;
import com.lzc.service.QuestionAnswerService;
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
