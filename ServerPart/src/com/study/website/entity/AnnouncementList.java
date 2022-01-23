package com.study.website.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * (AnnouncementList)表实体类
 *
 * @author Feiji
 * @since 2021-04-30 09:46:21
 */
@Data
@TableName(value = "Announcement_List")
public class AnnouncementList extends Model<AnnouncementList> {

    @TableId(type = IdType.AUTO)
    /**主键*/
    private Long aId;
    /**
     * 课程编号
     */
    private Long aSubject;
    /**
     * 公告内容
     */
    private String aAnnouncement;
    /**
     * 发布时间
     */
    private LocalDate aDate;
    /**
     * 发布人
     */
    private Long aTeacher;

    private String vdef1;

    private String vdef2;

    private String vdef3;

    private String vdef4;

    private String vdef5;

    private String vdef6;

    private String vdef7;

    private String vdef8;

    private String vdef9;

    private String vdef10;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.aId;
    }
}