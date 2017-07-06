package ksowka.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class Facebook {
    private String id;
    private LocalDate birthday;
    private String firstname;
    private String lastname;
    private String occupation;
    private Gender gender;
    private City city;
    private String work;
    private List<String> friends;
    private String school;
    private String location;
    private String relationship;
    private Map<Integer, String> posts;

}




