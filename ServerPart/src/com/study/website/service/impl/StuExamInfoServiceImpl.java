package com.study.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.website.dao.StuExamInfoDao;
import com.study.website.dao.StuGradesDao;
import com.study.website.entity.StuExamInfo;
import com.study.website.entity.StuGrades;
import com.study.website.service.StuExamInfoService;
import com.study.website.service.SubjectListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * (StuExamInfo)表服务实现类
 *
 * @author Feiji
 * @since 2021-03-30 19:32:33
 */
@Service("stuExamInfoService")
public class StuExamInfoServiceImpl extends ServiceImpl<StuExamInfoDao, StuExamInfo> implements StuExamInfoService {

    @Resource
    SubjectListService subjectListService;

    @Resource
    StuGradesDao stuGradesDao;

    @Override
    public void setStuExam(ArrayList<Object> multipleDTOMap, ArrayList<Object> shortDTOMap, Long examId,Long suId,Long stuId) {
        //调用批改单选题的方法 获取分数
        Double scores = new Double(0);
        scores += setMultipleScores(multipleDTOMap);
        scores += setShortScores(shortDTOMap);
        //创建学生成绩表对象
        StuGrades stuGrades = new StuGrades();
        stuGrades.setSuId(suId);
        stuGrades.setEId(examId);
        stuGrades.setStuId(stuId);
        Long tId = subjectListService.getTIdBySuId(suId);
        stuGrades.setTId(tId);
        stuGrades.setSgScores(scores);

        stuGradesDao.insert(stuGrades);
    }

    /**
     * 批改单选题
     * @return
     */
    public Double setMultipleScores(ArrayList<Object> multipleDTOMap) {
        Double scores = new Double(0);
        for(int i=0;i<multipleDTOMap.size();i++) {
            ArrayList<Object> list = (ArrayList<Object>)multipleDTOMap.get(i);
            HashMap<String,Object> map = (HashMap<String,Object>)list.get(1);
            //获取答案与选项
            String choice = String.valueOf(map.get("choice"));
            String mAnswer = String.valueOf(map.get("mAnswer"));
            if(choice.equals(mAnswer)) {
                double qScores = Double.valueOf((Integer)map.get("qScores"));
                scores += qScores;
            }
        }
        return scores;
    }

    /**
     * 批改简答题
     * @return
     */
    public Double setShortScores(ArrayList<Object> shortDTOMap) {
        Double scores = new Double(0);
        for(int i=0;i<shortDTOMap.size();i++) {
            ArrayList<Object> list = (ArrayList<Object>)shortDTOMap.get(i);
            HashMap<String,Object> map = (HashMap<String,Object>)list.get(1);
            //获取答案与选项
            String text = String.valueOf(map.get("text"));
            String answer = String.valueOf(map.get("answer"));
            if(text.equals(answer)) {
                double qscores = Double.valueOf((Integer)map.get("scores"));
                scores += qscores;
            }
        }
        return scores;
    }
}