package com.study.website.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.website.dtos.AnnounceListDTO;
import com.study.website.entity.AnnouncementList;

import java.util.ArrayList;

/**
 * (AnnouncementList)表服务接口
 *
 * @author Feiji
 * @since 2021-04-30 09:46:21
 */
public interface AnnouncementListService extends IService<AnnouncementList> {

    ArrayList<AnnounceListDTO> showList(Long suId);
}