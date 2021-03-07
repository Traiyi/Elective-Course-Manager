package com.traiyi.controller;

import com.traiyi.common.CommonResult;
import com.traiyi.pojo.Specialty;
import com.traiyi.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Traiyi
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

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Specialty>> list() {
        return CommonResult.success(specialtyService.list());
    }

    @RequestMapping(value = "list-all", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Specialty>> listAll() {
        return CommonResult.success(specialtyService.listSpecialtyMoreAndOneGrade());
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody Specialty specialty) {
        System.out.println(specialty);
        specialtyService.add(specialty);
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
