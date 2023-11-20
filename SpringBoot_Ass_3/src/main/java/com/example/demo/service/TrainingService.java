package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Training;

public interface TrainingService {

	List<Training> getAllTrainings();

	Training getTrainingById(String trainingId) throws Exception;

	Training updateTraining(Training training) throws Exception;

	Training registerTraining(Training training);

	String removeTraining(String trainingId) throws Exception;

}
