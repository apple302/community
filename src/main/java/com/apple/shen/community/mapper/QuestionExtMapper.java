package com.apple.shen.community.mapper;

import com.apple.shen.community.model.Question;
import com.apple.shen.community.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {

    int incView(Question record);
    int incCommentCount(Question record);
    List<Question> selectRelated(Question question);

}