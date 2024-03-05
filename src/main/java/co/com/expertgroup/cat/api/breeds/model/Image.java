package co.com.expertgroup.cat.api.breeds.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image implements Serializable {

    private String id;
    private int width;
    private int height;
    private String url;
}
