package com.traiyi.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.traiyi.pojo.Category;
import com.traiyi.service.CategoryService;
import com.traiyi.util.Page;

/**
 * @author : Traiyi
 * @Class : CategoryController
 * @description : 测试控制类
 * @date : 2021-03-07 16:31
 */

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;



    @RequestMapping("listCategory")
    public ModelAndView listCategory(Page page){
        ModelAndView mav = new ModelAndView();
        PageHelper.offsetPage(page.getStart(),5);
        List<Category> cs= categoryService.list();
        int total = (int) new PageInfo<>(cs).getTotal();

        page.caculateLast(total);

        // 放入转发参数
        mav.addObject("cs", cs);
        // 放入jsp路径
        mav.setViewName("listCategory");
        System.out.println("????");
        return mav;
    }

    @RequestMapping("listCategory2")
    @ResponseBody
    public String listCategory2(@RequestBody String params){
        System.out.println(params);

        Category c = new Category();
        c.setId(100);
        c.setName("第100个分类");
        JSONObject json= new JSONObject();
        json.put("category", JSONObject.toJSON(c));
        return json.toJSONString();
    }



    @RequestMapping("addCategory")
    public ModelAndView addCategory(Category category) {
        categoryService.add(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }

    @RequestMapping("deleteCategory")
    public ModelAndView deleteCategory(Category category) {
        categoryService.delete(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }

    @RequestMapping("editCategory")
    public ModelAndView editCategory(Category category) {
        Category c = categoryService.get(category.getId());
        ModelAndView mav = new ModelAndView("editCategory");
        mav.addObject("c", c);
        return mav;
    }

    @RequestMapping("updateCategory")
    public ModelAndView updateCategory(Category category) {
        categoryService.update(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }


}

