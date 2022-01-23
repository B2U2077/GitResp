package com.study.website.vos;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.dtos.StuGradesDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author FeiJi
 * @date 2021-05-10
 */
@Data
public class StuGradesVO implements Serializable {

    Page<StuGradesDTO> page;

    Long suId;
}
