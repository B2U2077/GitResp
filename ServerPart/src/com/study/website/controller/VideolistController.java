package com.study.website.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.entity.Videolist;
import com.study.website.service.VideolistService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * (Videolist)表控制层
 *
 * @author Feiji
 * @since 2021-04-28 10:05:53
 */
@CrossOrigin
@RestController
@RequestMapping("/videolist")
public class VideolistController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private VideolistService videolistService;

    /**
     * 分页查询所有数据
     *
     * @param page      分页对象
     * @param videolist 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Videolist> page, Videolist videolist) {
        return success(this.videolistService.page(page, new QueryWrapper<>(videolist)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.videolistService.getById(id));
    }

    /**
     * 新增数据
     *
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestParam(value = "vName") String vName, @RequestParam(value = "file") MultipartFile file,@RequestParam(value = "suId") Long suId) throws IOException {
        Videolist videolist = new Videolist();
        if(file != null) {
            String locationPath = "F://Graduation_Project//uploadVideo//";
            System.out.println("上传路径：" + locationPath);
            //上传文件名
            String fileName = UUID.randomUUID().toString().replaceAll("-","") + file.getOriginalFilename();
            //上传文件类型
            System.out.println("文件类型：" + file.getContentType());
            //创建源文件对象
            File sourceFile = new File(locationPath,fileName);
            if(!sourceFile.exists()) {
                sourceFile.mkdirs();
            }
            //将上传文件移至目标文件中
            file.transferTo(new File(locationPath,fileName));
            videolist.setVPath("http://localhost:8001/study/video/" + fileName);
            videolist.setVName(vName);
        }
        videolist.setVSub(suId);
        return success(this.videolistService.save(videolist));
    }

    /**
     * 修改数据
     *
     * @param videolist 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Videolist videolist) {
        return success(this.videolistService.updateById(videolist));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.videolistService.removeByIds(idList));
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public ArrayList<Videolist> getVideoList(@RequestParam(value = "suId")Long suId) {
        ArrayList<Videolist> list = videolistService.getVideoList(suId);
        System.out.println("获取的视频列表：" + list);
        return list;
    }
}