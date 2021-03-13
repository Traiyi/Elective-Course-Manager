package com.traiyi.controller;

import com.traiyi.common.CommonResult;
import com.traiyi.pojo.Grade;
import com.traiyi.pojo.ListData;
import com.traiyi.pojo.SelectCondition;
import com.traiyi.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Traiyi
 * @Class : GradeController
 * @description : 年级控制类
 * @date : 2021-03-07 16:44
 */

@CrossOrigin
@Controller
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    GradeService gradeService;


    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ListData> list(@RequestBody SelectCondition selectCondition) {
        System.out.println(selectCondition);
//        selectCondition.setPage((selectCondition.getPage()-1)*selectCondition.getLimit());
        selectCondition.caculateStart();
        System.out.println(selectCondition);
        return CommonResult.success(new ListData(gradeService.list(selectCondition),gradeService.total()));
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody Grade grade) {
        System.out.println(grade);
        CommonResult commonResult;
        int count = gradeService.add(grade);
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
        int count = gradeService.delete(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("操作失败");
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody Grade grade) {
        System.out.println(grade);
        int count = gradeService.update(grade);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("操作失败");
        }
    }
}
