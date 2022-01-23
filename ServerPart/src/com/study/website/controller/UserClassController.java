package com.study.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.dtos.ClassListDTO;
import com.study.website.entity.UserClass;
import com.study.website.service.UserClassService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (UserClass)表控制层
 *
 * @author Feiji
 * @since 2021-04-28 17:05:00
 */
@CrossOrigin
@RestController
@RequestMapping("/userClass")
public class UserClassController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserClassService userClassService;

    /**
     * 分页查询所有数据
     *
     * @param page      分页对象
     * @param userClass 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<UserClass> page, UserClass userClass) {
        return success(this.userClassService.page(page, new QueryWrapper<>(userClass)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/getOne" ,method = RequestMethod.POST)
    public boolean selectOne(@RequestParam("id") Long id,@RequestParam("role") String role,@RequestParam("suId") Long suId) {
        UserClass userClass = this.userClassService.getOne(role,id,suId);
        boolean flag = false;
        if(userClass != null) {
            flag = true;
        }
        return flag;
    }

    /**
     * 新增数据
     *
     * @param userClass 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody UserClass userClass) {
        return success(this.userClassService.save(userClass));
    }

    /**
     * 修改数据
     *
     * @param userClass 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody UserClass userClass) {
        return success(this.userClassService.updateById(userClass));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userClassService.removeByIds(idList));
    }

    @ResponseBody
    @RequestMapping(value = "/classList",method = RequestMethod.POST)
    public ArrayList<ClassListDTO> showUserClassList(@RequestParam(value = "id")Long id, @RequestParam(value = "role")String role) {
        ArrayList<ClassListDTO> list = userClassService.showUserClassList(role,id);
        System.out.println(list);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/getAllList",method = RequestMethod.POST)
    public ArrayList<ClassListDTO> showAllList() {
        ArrayList<ClassListDTO> dtos = userClassService.getAllList();
        return dtos;
    }
}