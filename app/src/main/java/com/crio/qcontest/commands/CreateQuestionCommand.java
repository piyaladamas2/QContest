package com.crio.qcontest.commands;

import java.util.List;

import com.crio.qcontest.entities.DifficultyLevel;
import com.crio.qcontest.entities.Question;
import com.crio.qcontest.services.QuestionService;

public class CreateQuestionCommand implements ICommand{
    private final QuestionService questionService;

    public CreateQuestionCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void invoke(List<String> tokens) {
        
        String title= tokens.get(1);
        String level= tokens.get(2);
        Integer difficultyScore= Integer.parseInt(tokens.get(3));
        
        Question question= questionService.createQuestion(title,DifficultyLevel.valueOf(level), difficultyScore);

        System.out.println("Question Id: "+ question.getId());
    }

}
