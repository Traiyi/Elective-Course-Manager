package com.lzc.controller;

import com.lzc.common.CommonResult;
import com.lzc.pojo.ListData;
import com.lzc.pojo.SelectCondition;
import com.lzc.pojo.Specialty;
import com.lzc.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Lzc
 * @Class : SpecialtyController
 * @description : TODO
 * @date : 2021-03-07 16:51
 */

@CrossOrigin
@Controller
@RequestMapping("/specialty")
public class SpecialtyController {
    @Autowired
    SpecialtyService specialtyService;

    @RequestMapping(value = "list-all", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ListData> listAll(@RequestBody SelectCondition selectCondition) {
        selectCondition.caculateStart();
        System.out.println(selectCondition);
        return CommonResult.success(new ListData(specialtyService.list(selectCondition),specialtyService.total()));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody Specialty specialty) {
        CommonResult commonResult;
        int count = specialtyService.add(specialty);
        if (count == 1) {
            commonResult = CommonResult.success("²Ù×÷³É¹¦");
        } else {
            commonResult = CommonResult.failed("²Ù×÷Ê§°Ü");
        }
        return commonResult;

    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@RequestParam(value = "id") int id) {
        int count = specialtyService.delete(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("²Ù×÷Ê§°Ü");
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody Specialty specialty) {
        System.out.println(specialty);
        int count = specialtyService.update(specialty);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("²Ù×÷Ê§°Ü");
        }
    }
}
