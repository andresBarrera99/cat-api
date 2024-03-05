package co.com.expertgroup.cat.api.breeds.service;

import co.com.expertgroup.cat.api.breeds.model.Breed;

import java.util.List;

public interface BreedService {

    public List<Breed> getBreedsById(String breedId);
    public List<Breed> getBreedsByName(String breedName);
}
