package com.lzc.controller;

import com.lzc.common.CommonResult;
import com.lzc.pojo.ListData;
import com.lzc.pojo.SelectCondition;
import com.lzc.pojo.Student;
import com.lzc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author : Lzc
 * @Class : AdminStudentController
 * @description : 管理员管理学生控制类
 * @date : 2021-03-07 15:37
 */

@CrossOrigin
@Controller
@RequestMapping("/student")
public class AdminStudentController {
    @Autowired
    StudentService studentService;

//
//    @RequestMapping(value = "list-all", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<List<Student>> listAll() {
//        return CommonResult.success(studentService.listStudentAll());
//    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ListData> list(@RequestBody SelectCondition selectCondition) {
        System.out.println(selectCondition);
        selectCondition.caculateStart();
        System.out.println(selectCondition);
        return CommonResult.success(new ListData(studentService.list(selectCondition),studentService.total()));
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody Student student) {
        System.out.println(student);
        studentService.add(student);
        CommonResult commonResult;
        int count = studentService.add(student);
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
        int count = studentService.delete(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("操作失败");
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody Student student) {
        System.out.println(student);
        int count = studentService.update(student);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("操作失败");
        }
    }
}
