package com.study.website.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 显示所有公告的数据传输对象
 * @author FeiJi
 * @date 2021-04-30
 */
@Data
public class AnnounceListDTO implements Serializable {

    String aAnnouncement;

    String tName;

    LocalDate aDate;
}
