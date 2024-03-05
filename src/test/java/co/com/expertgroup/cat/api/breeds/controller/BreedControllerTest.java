package co.com.expertgroup.cat.api.breeds.controller;

import co.com.expertgroup.cat.api.breeds.model.Breed;
import co.com.expertgroup.cat.api.breeds.service.BreedService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BreedController.class)
public class BreedControllerTest {

    @Autowired
    protected MockMvc mvc;
    @MockBean
    private BreedService service;


    @Test
    public void getBreedsById_whenBreedIdIsNull() throws Exception {
        Breed mock = new Breed();
        mock.setId("mock");
        Mockito.when(service.getBreedsById(eq(null))).thenReturn(List.of(mock));
        mvc.perform(get("/breeds/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
    }
    @Test
    public void getBreedsById_whenBreedIdIsNotNull() throws Exception {
        Mockito.when(service.getBreedsById(eq("mock"))).thenReturn(List.of());
        mvc.perform(get("/breeds/mock")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }

}