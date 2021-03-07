package com.traiyi.service;

import com.traiyi.pojo.QuestionAnswer;
import com.traiyi.util.Page;

import java.util.List;

public interface QuestionAnswerService {

    List<QuestionAnswer> list();

    int total();

    List<QuestionAnswer> list(Page page);

    int add(QuestionAnswer c);

    int update(QuestionAnswer c);

    int delete(int id);

    QuestionAnswer get(int id);
}
