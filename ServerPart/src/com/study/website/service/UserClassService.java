package com.study.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.website.dtos.ClassListDTO;
import com.study.website.entity.UserClass;

import java.util.ArrayList;

/**
 * (UserClass)表服务接口
 *
 * @author Feiji
 * @since 2021-04-28 17:05:00
 */
public interface UserClassService extends IService<UserClass> {

    ArrayList<ClassListDTO> showUserClassList(String role, Long id);

    ArrayList<ClassListDTO> getAllList();

    UserClass getOne(String role,Long id,Long suId);
}