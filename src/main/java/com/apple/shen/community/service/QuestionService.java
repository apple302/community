package com.apple.shen.community.service;

import com.apple.shen.community.dto.PaginationDTO;
import com.apple.shen.community.dto.QuestionDTO;
import com.apple.shen.community.mapper.QuestionMapper;
import com.apple.shen.community.mapper.UserMapper;
import com.apple.shen.community.model.Question;
import com.apple.shen.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO list(Integer page, Integer size) {

        //获取问题总数量
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);

        if(page < 1){
            page = 1;
        }
        if(page > paginationDTO.getTotalPage()){
            page = paginationDTO.getTotalPage();
        }

        // 5*(n-1)：每页5条数据
        Integer offset = size * (page -1);
        List<Question> questionList = questionMapper.list(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questionList) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);


        return paginationDTO;
    }
}
