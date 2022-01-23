package com.study.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.entity.School;
import com.study.website.service.SchoolService;
import com.study.website.vos.SchoolPageVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * (School)表控制层
 *
 * @author Feiji
 * @since 2021-03-30 19:32:32
 */
@CrossOrigin
@RestController
@RequestMapping("/school")
public class SchoolController extends ApiController {

    /**
     * 服务对象
     */
    @Resource
    private SchoolService schoolService;

    /**
     * 上传图片的绝对路径
     */
    @Value("${file.location}")
    String fileLocationPath;

    /**
     * 虚拟路径
     */
    @Value("${file.path}")
    String vpath;

    /**
     * 分页查询所有数据
     *
     * @param vo  学校分页视图对象
     * @return 所有数据
     */
    @RequestMapping(value = "/schoolVo",method = RequestMethod.POST)
    public R selectAll(@RequestBody SchoolPageVO vo) {
        Page<School> page = vo.getPage();
        School school = vo.getSchool();
        return success(this.schoolService.page(page, new QueryWrapper<>(school)));
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.schoolService.getById(id));
    }

    /**
     * 新增数据
     *
     * @return 新增结果
     */
    @PostMapping
    @ResponseBody
    public Map<String,Object> insert(@RequestParam(value = "scName",required = false) String scName,
                      @RequestParam(value = "scId",required = false) String scId,
                      @RequestParam(value = "scInfo",required = false) String scInfo,
                      @RequestParam(value = "vdef1",required = false) String vdef1,
                      @RequestParam(value = "vdef2",required = false) String vdef2,
                      @RequestParam(value = "vdef3",required = false) String vdef3,
                      @RequestParam(value = "vdef4",required = false) String vdef4,
                      @RequestParam(value = "vdef5",required = false) String vdef5,
                      @RequestParam(value = "vdef6",required = false) String vdef6,
                      @RequestParam(value = "vdef7",required = false) String vdef7,
                      @RequestParam(value = "vdef8",required = false) String vdef8,
                      @RequestParam(value = "vdef9",required = false) String vdef9,
                      @RequestParam(value = "vdef10",required = false) String vdef10,
                      @RequestParam(value = "isEdit",required = false) boolean isEdit,
                      @RequestParam(value = "file",required = false) MultipartFile file) throws IOException {

        /**
         * 封装学校信息
         */
        School school = new School();
        school.setScName(scName);
        school.setScStatus("1");
        school.setScInfo(scInfo);
        school.setVdef1(vdef1);
        school.setVdef2(vdef2);
        school.setVdef3(vdef3);
        school.setVdef4(vdef4);
        school.setVdef5(vdef5);
        school.setVdef6(vdef6);
        school.setVdef7(vdef7);
        school.setVdef8(vdef8);
        school.setVdef9(vdef9);
        school.setVdef10(vdef10);

        Map<String,Object> map = new HashMap<>();
        /**
         * 处理图片
         */
        if(file != null) {
            System.out.println("上传路径：" + fileLocationPath);
            //上传文件名
            String fileName = UUID.randomUUID().toString().replaceAll("-","") + file.getOriginalFilename();
            //上传文件类型
            System.out.println("文件类型："+file.getContentType());
            //创建一个文件对象，把存放文件的路径和文件名放进去
            File filePath = new File(fileLocationPath,fileName);
            //若路径不存在就创建一个路径
            if(!filePath.exists()) {
                filePath.mkdirs();
            }
            //将上传文件保存在一个目标文件中
            file.transferTo(new File(fileLocationPath + fileName));
            school.setVdef10(vpath+fileName);
            map.put("fileName",vpath+fileName);
        }
        //若处于编辑状态
        if(isEdit) {
            school.setScId(Long.parseLong(scId));
            success(this.schoolService.updateById(school));
        } else {
            //新增数据
            success(this.schoolService.save(school));
        }
        return map;
    }


    /**
     * 删除数据
     *
     * @param id  主键
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("scId") Long id) {
        return success(this.schoolService.removeById(id));
    }
}