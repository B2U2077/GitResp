package com.study.website.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * @author FeiJi
 * @date 2021-05-09
 */
@Data
public class ShortDTO implements Serializable {

    private Double qScores;

    private int qIndex;

    private String shText;

    private String shAnswer;

    private Long shId;

    private String shWrite;
}
