package com.lzc.controller;

import com.lzc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Lzc
 * @Class : StudentController
 * @description : 学生控制类
 * @date : 2021-03-07 16:52
 */

@CrossOrigin
@Controller
@RequestMapping("/user")
public class StudentController {
    @Autowired
    StudentService studentService;


}
