package com.study.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.website.dao.VideolistDao;
import com.study.website.entity.Videolist;
import com.study.website.service.VideolistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * (Videolist)表服务实现类
 *
 * @author Feiji
 * @since 2021-04-28 10:05:53
 */
@Service("videolistService")
public class VideolistServiceImpl extends ServiceImpl<VideolistDao, Videolist> implements VideolistService {

    @Resource
    VideolistDao videolistDao;

    @Override
    public ArrayList<Videolist> getVideoList(Long suId) {

        return videolistDao.getVideoList(suId);
    }
}