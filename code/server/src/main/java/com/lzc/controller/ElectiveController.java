package com.lzc.controller;

import com.lzc.common.CommonResult;
import com.lzc.pojo.Elective;
import com.lzc.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Lzc
 * @Class : CategoryController
 * @description : 选修操作控制类
 * @date : 2021-03-07 16:31
 */

@CrossOrigin
@Controller
@RequestMapping("/elective")
public class ElectiveController {
    @Autowired
    ElectiveService electiveService;


    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Elective>> list() {
        return CommonResult.success(electiveService.list());
    }


    @RequestMapping(value = "list-elective-pass", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Elective>> listElectivePass(@RequestParam(value = "id") int id) {
        return CommonResult.success(electiveService.listElectivePass(id));
    }

    @RequestMapping(value = "list-elective-no-pass", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Elective>> listElectiveNoPass(@RequestParam(value = "id") int id) {
        return CommonResult.success(electiveService.listElectiveNoPass(id));
    }

    @RequestMapping(value = "list-student", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Elective>> listStudent(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name) {
        return CommonResult.success(electiveService.listStudent(id, name));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody Elective elective) {
        CommonResult commonResult;
        int count = electiveService.add(elective);
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
        int count = electiveService.delete(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("操作失败");
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody Elective elective) {
        System.out.println(elective);
        int count = electiveService.update(elective);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("操作失败");
        }
    }

    @RequestMapping(value = "total-elective", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Integer> totalElective(@RequestParam(value = "id") int id) {
//        System.out.println(elective);
        return CommonResult.success(electiveService.totalElective(id));
    }

}
