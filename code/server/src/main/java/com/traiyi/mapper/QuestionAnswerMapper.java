package com.traiyi.mapper;

import com.traiyi.pojo.QuestionAnswer;
import com.traiyi.util.Page;

import java.util.List;

public interface QuestionAnswerMapper {


    public int add(QuestionAnswer questionAnswer);


    public int delete(int id);


    public QuestionAnswer get(int id);


    public int update(QuestionAnswer questionAnswer);


    public List<QuestionAnswer> list();

    public List<QuestionAnswer> list(Page page);


    public int total();

}