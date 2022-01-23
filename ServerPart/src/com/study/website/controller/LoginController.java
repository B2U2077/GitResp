package com.study.website.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.study.website.entity.Student;
import com.study.website.entity.Teacher;
import com.study.website.service.StudentService;
import com.study.website.service.TeacherService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 登陆页面
 * @author FeiJi
 * @date 2021-03-19
 */
@Api(tags = "用户登陆列表")
@CrossOrigin
@RestController
@RequestMapping("/user")
public class LoginController extends ApiController {

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;


    @ResponseBody
    @PostMapping
    public Object login(@RequestBody Map<String,Object> requestMap) {

        String identity = String.valueOf(requestMap.get("userIdentity"));
        String account = String.valueOf(requestMap.get("userName"));
        String password = String.valueOf(requestMap.get("userPassword"));
        HashMap<String,Object> map = new HashMap<>();
        //判断登录角色
        if(identity.equals("教师")) {
            Teacher teacher = teacherService.findTeacherByAccount(account,password);
            if(teacher == null) {
                map.put("flag",false);
            } else {
                map.put("flag",true);
                map.put("id",teacher.getTId());
            }
        } else if(identity.equals("学生")) {
            Student student = studentService.findStuByAccount(account,password);
            if(student == null) {
                map.put("flag",false);
            } else {
                map.put("flag",true);
                map.put("id",student.getStuId());
            }
        } else if(identity.equals("管理员")) {
            map.put("flag",true);
        }
        map.put("success","success");
        return map;
    }
}
