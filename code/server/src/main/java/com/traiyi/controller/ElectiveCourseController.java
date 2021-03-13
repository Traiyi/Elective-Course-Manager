package com.traiyi.controller;

import com.traiyi.common.CommonResult;
import com.traiyi.pojo.ElectiveCourse;
import com.traiyi.service.ElectiveCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Traiyi
 * @Class : ElectiveCourseController
 * @description : 选修课控制类
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
    public CommonResult<List<ElectiveCourse>> list() {
        return CommonResult.success(electiveCourseService.list());
    }


    @RequestMapping(value = "list-all", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ElectiveCourse>> listAll() {
        return CommonResult.success(electiveCourseService.listElectiveCourseAll());
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody ElectiveCourse electiveCourse) {
        System.out.println(electiveCourse);
        electiveCourseService.add(electiveCourse);
        CommonResult commonResult;
        int count = electiveCourseService.add(electiveCourse);
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
        int count = electiveCourseService.delete(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("操作失败");
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
            return CommonResult.failed("操作失败");
        }
    }
}
