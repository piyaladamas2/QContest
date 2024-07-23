package com.crio.qcontest.services;

 import java.util.Collections;
import java.util.List;

import com.crio.qcontest.entities.DifficultyLevel;
import com.crio.qcontest.entities.Question;
import com.crio.qcontest.repositories.IQuestionRepository;
import com.crio.qcontest.repositories.QuestionRepository;

public class QuestionService{

    private final IQuestionRepository questionRepository;

    public QuestionService(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    /**
     * Creates a new question with specified parameters.
     * @param title Title of the question.
     * @param level Difficulty level of the question.
     * @param difficultyScore Difficulty score of the question.
     * @return Created Question object.
     */
    public Question createQuestion(String title,DifficultyLevel level, Integer difficultyScore) {
        Question newQuestion= new Question(title,level,difficultyScore);
        Question question = questionRepository.save(newQuestion);
        return question;
    }

    /**
     * Retrieves a list of questions filtered by difficulty level.
     * @param level Difficulty level filter (can be null).
     * @return List of questions filtered by difficulty level.
     */
    
    public List<Question> listQuestions(DifficultyLevel level) {
        List<Question> listOfQuestions;
    
        if (level != null) {
            listOfQuestions = questionRepository.findByDifficultyLevel(level);
        } else {
            listOfQuestions = questionRepository.findAll();
        }
    
        return listOfQuestions;
    }
    
    
        
}