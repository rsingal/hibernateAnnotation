package com.rsingal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TRAINING")
public class Training {

	private Integer trainingId;
	private String trainingName;

	public Training() {
	}

	public Training(String trainingName) {
		this.trainingName = trainingName;
	}

	@Override
	public String toString() {
		return "Training [trainingId = " + trainingId + ", trainingName = " + trainingName + "]";
	}

	@Id
	@GenericGenerator(name = "mygen1", strategy = "increment")
	@GeneratedValue(generator = "mygen1")
	@Column(name = "ID_TRAINING", unique = true, nullable = false)
	public Integer getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}

	@Column(name = "TRAINING_NAME", nullable = false, length = 32)
	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
}
