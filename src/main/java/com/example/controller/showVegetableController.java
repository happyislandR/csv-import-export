package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.common.Batch;
import com.example.domain.Vegetable;
import com.example.service.showVegetableService;

@Controller
@RequestMapping("/csv")
public class showVegetableController {
	
	@Autowired
	private showVegetableService showVegetableService;
	
	@RequestMapping("")
	public String index() {
		return "start";
	}

	@RequestMapping("/import")
	public String csvImport(Model model) {
		Batch b = new Batch();
		List<Vegetable> vegetableList = b.importCSV();
		model.addAttribute("vegetableList", vegetableList);
		for(Vegetable vegetable : vegetableList) {
			showVegetableService.addVegetable(vegetable);
		}
		return "finishedImport";
	}
	
	@RequestMapping("/export")
	public String csvExport(Model model) {
		
		List<Vegetable> vegetableExportList = showVegetableService.showVegetable();
		Batch b = new Batch();
		b.exportCSV(vegetableExportList);
		model.addAttribute("vegetableExportList", vegetableExportList);
		return "finishedExport";
	}
}
