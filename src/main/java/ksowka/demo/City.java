package ksowka.demo;

import lombok.Data;

@Data
public class City {

    private String countryName;
    private String cityName;
    private String stateName;
    private Coords coords;

}
