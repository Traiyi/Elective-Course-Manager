package com.traiyi.controller;

import com.traiyi.common.CommonResult;
import com.traiyi.pojo.Student;
import com.traiyi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author : Traiyi
 * @Class : AdminStudentController
 * @description : ����Ա����ѧ��������
 * @date : 2021-03-07 15:37
 */

@CrossOrigin
@Controller
@RequestMapping("/student")
public class AdminStudentController {
    @Autowired
    StudentService studentService;


    @RequestMapping(value = "list-all", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Student>> listAll() {
        return CommonResult.success(studentService.listStudentAll());
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Student>> list() {
        return CommonResult.success(studentService.list());
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody Student student) {
        System.out.println(student);
        studentService.add(student);
        CommonResult commonResult;
        int count = studentService.add(student);
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
        int count = studentService.delete(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("����ʧ��");
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
            return CommonResult.failed("����ʧ��");
        }
    }
}
