package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Training;
import com.example.demo.service.TrainingService;

@RestController
@RequestMapping("Trainings")
public class TrainingController {

	@Autowired
	private TrainingService trainingService;

	@GetMapping("/showAll")
	public ResponseEntity<List<Training>> getAllTrainings() {
		List<Training> trainings = trainingService.getAllTrainings();
		return new ResponseEntity<List<Training>>(trainings, HttpStatus.OK);
	}

	@GetMapping("/{trainingId}")
	public ResponseEntity<Training> getTrainingDetailsById(@PathVariable String trainingId) throws Exception {
		Training training = trainingService.getTrainingById(trainingId);
		return new ResponseEntity<Training>(training, HttpStatus.FOUND);
	}

	@PostMapping("/registerTraining")
	public ResponseEntity<Training> registerTraining(@RequestBody Training training) {
		return new ResponseEntity<Training>(trainingService.registerTraining(training), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Training> updateTraining(@RequestBody Training training) throws Exception {
		return new ResponseEntity<Training>(trainingService.updateTraining(training), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{trainingId}")
	public ResponseEntity<String> removeTraining(@PathVariable String trainingId) throws Exception{
		return new ResponseEntity<String>(trainingService.removeTraining(trainingId),HttpStatus.OK);
	}
}
