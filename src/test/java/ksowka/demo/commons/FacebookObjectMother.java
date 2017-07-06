package ksowka.demo.commons;

import ksowka.demo.Facebook;

import java.time.LocalDate;

public class FacebookObjectMother {

    public static Facebook facebookWithFirstName(String firstName){
        return Facebook.builder()
                .id("1")
                .birthday(LocalDate.now())
                .firstname(firstName)
                .lastname("Kling")
                .occupation("Direct Applications Administrator")
                .gender(null)
                .city(null)
                .work("Lebsack - Rippin")
                .friends(null)
                .school("Walter, Cartwright and Jerde")
                .location("London")
                .relationship("Married")
                .posts(null)
                .build();
    }
}
