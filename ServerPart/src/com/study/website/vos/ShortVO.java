package com.study.website.vos;

import lombok.Data;

import java.io.Serializable;

/**
 * @author FeiJi
 * @date 2021-05-09
 */
@Data
public class ShortVO implements Serializable {

    Long qExam;

    String qType;
}
