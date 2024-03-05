package co.com.expertgroup.cat.api.breeds.service;

import co.com.expertgroup.cat.api.breeds.model.Breed;
import co.com.expertgroup.cat.api.breeds.repository.BreedRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BreedServiceImplTest {

    @Mock
    public BreedRepository repository;

    @InjectMocks
    private BreedServiceImpl service;

    @Test
    public void getBreedsByIdTest(){
        when(repository.getBreedsById(any())).thenReturn(List.of());
        service.getBreedsById(null);
        verify(repository, times(1)).getBreedsById(any());
    }

    @Test
    public void getBreedsByNameTest(){
        when(repository.getBreedsByName(eq("American"))).thenReturn(List.of(new Breed()));
        List<Breed> response = service.getBreedsByName("American");
        verify(repository, times(1)).getBreedsByName("American");
        assertFalse(response.isEmpty());
    }

}