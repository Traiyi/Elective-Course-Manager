package com.lzc.controller;

import com.lzc.common.CommonResult;
import com.lzc.pojo.QuestionAnswer;
import com.lzc.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Lzc
 * @Class : QuestionAnswerController
 * @description : 问答控制类
 * @date : 2021-03-07 16:47
 */

@CrossOrigin
@Controller
@RequestMapping("/question-answer")
public class QuestionAnswerController {
    @Autowired
    QuestionAnswerService questionAnswerService;


    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<QuestionAnswer>> list() {
        return CommonResult.success(questionAnswerService.list());
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody QuestionAnswer questionAnswer) {
        CommonResult commonResult;
        int count = questionAnswerService.add(questionAnswer);
        if (count == 1) {
            commonResult = CommonResult.success("操作成功");
        } else {
            commonResult = CommonResult.failed("操作失败");
        }
        return commonResult;

    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@RequestParam(value = "id") int id) {
        int count = questionAnswerService.delete(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("操作失败");
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody QuestionAnswer questionAnswer) {
        System.out.println(questionAnswer);
        int count = questionAnswerService.update(questionAnswer);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("操作失败");
        }
    }
}
