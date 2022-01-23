package com.study.website.vos;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.website.entity.School;
import lombok.Data;

/**
 * @author FeiJi
 * @date 2021-04-17
 */
@Data
public class SchoolPageVO {

    Page<School> page;

    School school;
}
