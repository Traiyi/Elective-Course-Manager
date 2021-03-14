package com.lzc.service;

import com.lzc.pojo.QuestionAnswer;
import com.lzc.pojo.SelectCondition;

import java.util.List;

public interface QuestionAnswerService {

    List<QuestionAnswer> list();

    int total();

    List<QuestionAnswer> list(SelectCondition selectCondition);

    int add(QuestionAnswer c);

    int update(QuestionAnswer c);

    int delete(int id);

    QuestionAnswer get(int id);
}
