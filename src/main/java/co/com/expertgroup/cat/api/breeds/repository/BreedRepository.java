package co.com.expertgroup.cat.api.breeds.repository;

import co.com.expertgroup.cat.api.breeds.model.Breed;

import java.util.List;

public interface BreedRepository {

    public List<Breed> getBreedsById(String breedId);
    public List<Breed> getBreedsByName(String breedName);
}
