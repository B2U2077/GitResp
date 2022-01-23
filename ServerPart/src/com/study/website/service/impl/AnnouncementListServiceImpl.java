package com.study.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.website.dao.AnnouncementListDao;
import com.study.website.dtos.AnnounceListDTO;
import com.study.website.entity.AnnouncementList;
import com.study.website.service.AnnouncementListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * (AnnouncementList)表服务实现类
 *
 * @author Feiji
 * @since 2021-04-30 09:46:21
 */
@Service("announcementListService")
public class AnnouncementListServiceImpl extends ServiceImpl<AnnouncementListDao, AnnouncementList> implements AnnouncementListService {

    @Resource
    AnnouncementListDao listDao;

    @Override
    public ArrayList<AnnounceListDTO> showList(Long suId) {

        return listDao.showList(suId);
    }
}