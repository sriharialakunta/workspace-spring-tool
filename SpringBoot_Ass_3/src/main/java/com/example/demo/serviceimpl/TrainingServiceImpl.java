package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Training;
import com.example.demo.repository.TrainingRepository;
import com.example.demo.service.TrainingService;
@Service
public class TrainingServiceImpl implements TrainingService {
	
	@Autowired
	private TrainingRepository trainingRepository;

	@Override
	public List<Training> getAllTrainings() {
		return trainingRepository.findAll();
	}

	@Override
	public Training getTrainingById(String trainingId) throws Exception {
		Optional<Training> isExist = trainingRepository.findById(trainingId);
		if(isExist.isEmpty())
			throw new Exception("No Training with this id = "+trainingId);
		return isExist.get();
	}

	public Training registerTraining(Training training) {
		return trainingRepository.save(training);
	}

	@Override
	public Training updateTraining(Training training) throws Exception {
		Training existingTraining = getTrainingById(training.getTrainingId());
		existingTraining.setStartDate(training.getStartDate());
		existingTraining.setEndDate(training.getEndDate());
		return trainingRepository.save(existingTraining);
	}
	
	public String removeTraining(String trainingId) throws Exception {
		Training existingStudent = getTrainingById(trainingId);
		trainingRepository.delete(existingStudent);
		return "Training removed with id = "+ trainingId;
	}


}
