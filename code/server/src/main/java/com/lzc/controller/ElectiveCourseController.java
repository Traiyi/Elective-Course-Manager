package com.lzc.controller;

import com.lzc.common.CommonResult;
import com.lzc.pojo.ElectiveCourse;
import com.lzc.pojo.ListData;
import com.lzc.pojo.SelectCondition;
import com.lzc.service.ElectiveCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Lzc
 * @Class : ElectiveCourseController
 * @description : ѡ�޿ο�����
 * @date : 2021-03-07 16:34
 */

@CrossOrigin
@Controller
@RequestMapping("/elective-course")
public class ElectiveCourseController {
    @Autowired
    ElectiveCourseService electiveCourseService;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ListData> listAll(@RequestBody SelectCondition selectCondition) {

        selectCondition.caculateStart();
        System.out.println(selectCondition);
        return CommonResult.success(new ListData(electiveCourseService.list(selectCondition),electiveCourseService.total()));
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody ElectiveCourse electiveCourse) {
        CommonResult commonResult;
        int count = electiveCourseService.add(electiveCourse);
        if (count == 1) {
            commonResult = CommonResult.success("�����ɹ�");
        } else {
            commonResult = CommonResult.failed("����ʧ��");
        }
        return commonResult;

    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@RequestParam(value = "id") int id) {
        int count = electiveCourseService.delete(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("����ʧ��");
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody ElectiveCourse electiveCourse) {
        System.out.println(electiveCourse);
        int count = electiveCourseService.update(electiveCourse);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("����ʧ��");
        }
    }
}
