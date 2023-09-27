package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DemoEntity;
import com.example.demo.repo.DemoRepository;

@RestController
@RequestMapping("/git")
public class GitDemoController {

	@Autowired
	private DemoRepository demorepository;

	@GetMapping("/getall")
	public List<DemoEntity> getAllDemoEntities() {
		return demorepository.findAll();
	}

	@GetMapping("/get/{id}")
	public Optional<DemoEntity> getDemoEntityById(@PathVariable long id) {
		return demorepository.findById(id);
	}

	@PostMapping("/post")
	public DemoEntity createDemoEntity(@RequestBody DemoEntity demoEntity) {
		return demorepository.save(demoEntity);
	}

	@PutMapping("/put/{id}")
	public DemoEntity updateDemoEntity(@PathVariable long id, @RequestBody DemoEntity updatedDemoEntity) {
		DemoEntity existingDemoEntity = demorepository.findById(id)
				.orElseThrow(() -> new RuntimeException("DemoEntity not found with id: " + id));

		existingDemoEntity.setName(updatedDemoEntity.getName());
		existingDemoEntity.setDepartment(updatedDemoEntity.getDepartment());

		return demorepository.save(existingDemoEntity);
	}

	@DeleteMapping("/del/{id}")
	public void deleteDemoEntity(@PathVariable long id) {
		demorepository.deleteById(id);
	}

}
