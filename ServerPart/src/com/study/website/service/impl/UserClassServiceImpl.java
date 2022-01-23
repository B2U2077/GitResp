package com.study.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.website.dao.UserClassDao;
import com.study.website.dtos.ClassListDTO;
import com.study.website.entity.UserClass;
import com.study.website.service.UserClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * (UserClass)表服务实现类
 *
 * @author Feiji
 * @since 2021-04-28 17:05:00
 */
@Service("userClassService")
public class UserClassServiceImpl extends ServiceImpl<UserClassDao, UserClass> implements UserClassService {

    @Resource
    UserClassDao userClassDao;

    @Override
    public ArrayList<ClassListDTO> showUserClassList(String role, Long id) {

        return userClassDao.showUserClassList(role,id);
    }

    @Override
    public ArrayList<ClassListDTO> getAllList() {
        return userClassDao.getAllList();
    }

    @Override
    public UserClass getOne(String role, Long id,Long suId) {
        return userClassDao.getOne(role,id,suId);
    }
}