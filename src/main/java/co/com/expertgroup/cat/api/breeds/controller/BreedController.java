package co.com.expertgroup.cat.api.breeds.controller;

import co.com.expertgroup.cat.api.breeds.model.Breed;
import co.com.expertgroup.cat.api.breeds.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/breeds")
public class BreedController {
	
	@Autowired
	public BreedService service;

	
	@GetMapping(value = {"/", "/{breed_id}"})
	public ResponseEntity<List<Breed>> getBreedsById(@PathVariable(value = "breed_id", required = false) String breedId){
		return ResponseEntity.ok(service.getBreedsById(breedId));
	}

	@GetMapping("/search")
	public ResponseEntity<List<Breed>> getBreeds(@RequestParam(value = "name",required = true) String breedName){
		return ResponseEntity.ok(service.getBreedsByName(breedName));
	}

}
