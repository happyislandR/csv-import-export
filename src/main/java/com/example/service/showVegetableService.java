package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Vegetable;
import com.example.repositroy.VegetableRepository;

@Service
@Transactional
public class showVegetableService {

	@Autowired
	private VegetableRepository vegetableRepository;
	
	public void addVegetable(Vegetable vegetable) {
		vegetableRepository.insert(vegetable);
	}
	
	public List<Vegetable> showVegetable() {
		List<Vegetable> vegetableList = vegetableRepository.findAll();
		return vegetableList;
	}
}
