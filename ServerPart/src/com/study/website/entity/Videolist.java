package com.study.website.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Videolist)表实体类
 *
 * @author Feiji
 * @since 2021-04-28 10:05:52
 */
@Data
@TableName(value = "Videolist")
public class Videolist extends Model<Videolist> {

    @TableId(type = IdType.AUTO)
    /**主键*/
    private Long vId;
    /**
     * 视频路径
     */
    private String vPath;
    /**
     * 视频名称
     */
    private String vName;

    /**
     * 课程编号
     */
    private Long vSub;

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
        return this.vId;
    }
}