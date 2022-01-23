package com.study.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.website.entity.Videolist;

import java.util.ArrayList;

/**
 * (Videolist)表服务接口
 *
 * @author Feiji
 * @since 2021-04-28 10:05:53
 */
public interface VideolistService extends IService<Videolist> {

    ArrayList<Videolist> getVideoList(Long suId);
}