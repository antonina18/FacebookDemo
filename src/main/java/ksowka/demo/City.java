package ksowka.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class City {

    private String countryName;
    private String cityName;
    private String stateName;
    private Coords coords;

}
