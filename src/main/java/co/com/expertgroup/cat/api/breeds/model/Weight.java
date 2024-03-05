package co.com.expertgroup.cat.api.breeds.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weight implements Serializable {
    private String imperial;
    private String metric;
}
