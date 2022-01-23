package com.study.website.vos;

import com.study.website.dtos.MultipleDTO;
import com.study.website.dtos.ShortDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author FeiJi
 * @date 2021-05-10
 */
@Data
public class StuExamVO implements Serializable {

    Map<Long,MultipleDTO> multipleDTOMap;

    Map<Long,ShortDTO> shortDTOMap;

    Long examId;
}
