package co.com.expertgroup.cat.api.breeds.service;

import co.com.expertgroup.cat.api.breeds.model.Breed;
import co.com.expertgroup.cat.api.breeds.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedServiceImpl implements BreedService{
    @Autowired
    public BreedRepository repository;

    @Override
    public List<Breed> getBreedsById(String breedId) {
        return repository.getBreedsById(breedId);
    }

    @Override
    public List<Breed> getBreedsByName(String breedName) {
        return repository.getBreedsByName(breedName);
    }
}
