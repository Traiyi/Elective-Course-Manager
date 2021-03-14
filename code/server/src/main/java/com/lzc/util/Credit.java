package com.lzc.util;

import com.lzc.mapper.ElectiveCourseMapper;
import com.lzc.pojo.Elective;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : Traiyi
 * @Class : Credit
 * @description : TODO
 * @date : 2021-03-14 16:22
 */
public class Credit {
    @Autowired
    ElectiveCourseMapper electiveCourseMapper;

    public void isPass(Elective elective) {
        double studentCredit = elective.getStudentCredit();
        double electiveCourseCredit = electiveCourseMapper.get(elective.getCourseID()).getCredit();
        System.out.println(studentCredit+" "+electiveCourseCredit);
        if (studentCredit < electiveCourseCredit)
            elective.setIsPass(0);
        else
            elective.setIsPass(1);
        System.out.println(elective);
    }
}
