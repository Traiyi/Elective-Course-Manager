package com.lzc.mapper;

import com.lzc.pojo.QuestionAnswer;
import com.lzc.pojo.SelectCondition;

import java.util.List;

public interface QuestionAnswerMapper {


    public int add(QuestionAnswer questionAnswer);


    public int delete(int id);


    public QuestionAnswer get(int id);


    public int update(QuestionAnswer questionAnswer);


    public List<QuestionAnswer> list();

    public List<QuestionAnswer> list(SelectCondition selectCondition);


    public int total();

}