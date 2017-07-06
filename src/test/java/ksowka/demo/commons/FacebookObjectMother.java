package ksowka.demo.commons;

import ksowka.demo.models.City;
import ksowka.demo.models.Coords;
import ksowka.demo.models.Facebook;
import ksowka.demo.models.Gender;

import java.sql.Timestamp;
import java.util.*;

import static java.util.Arrays.asList;

public class FacebookObjectMother {

    public static final String FACEBOOK_SIMPLE_AS_STRING = "{\n" +
            "  \"id\": \"1\",\n" +
            "  \"birthday\": 401280850089,\n" +
            "  \"firstname\": \"Luna\",\n" +
            "  \"lastname\": \"Kling\",\n" +
            "  \"occupation\": \"Direct Applications Administrator\",\n" +
            "  \"gender\": \"female\",\n" +
            "  \"city\": {\n" +
            "    \"countryName\": \"United Kingdom\",\n" +
            "    \"cityName\": \"London\",\n" +
            "    \"stateName\": \"England\",\n" +
            "    \"coords\": {\n" +
            "      \"lon\": -0.12574,\n" +
            "      \"lat\": 51.50853\n" +
            "    }\n" +
            "  },\n" +
            "  \"work\": \"Lebsack - Rippin\",\n" +
            "  \"friends\": [\n" +
            "    \"68\",\n" +
            "    \"38\",\n" +
            "    \"122\",\n" +
            "    \"115\",\n" +
            "    \"127\",\n" +
            "    \"128\",\n" +
            "    \"91\",\n" +
            "    \"82\",\n" +
            "    \"31\",\n" +
            "    \"53\",\n" +
            "    \"32\",\n" +
            "    \"65\",\n" +
            "    \"76\",\n" +
            "    \"87\"\n" +
            "  ],\n" +
            "  \"school\": \"Walter, Cartwright and Jerde\",\n" +
            "  \"location\": \"London\",\n" +
            "  \"relationship\": \"Married\",\n" +
            "  \"posts\": [\n" +
            "    {\n" +
            "      \"id\": \"1\",\n" +
            "      \"message\": \"Beautiful picture. Curve is nice if you sit within The radius. Nice interface. Enjoyable to watch TV and YouTube as well Netflix. Like the voice recognition software.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"2\",\n" +
            "      \"message\": \"What a great picture, what great sound.! No more glare.!!!! I love this TV. I bought this on for $1299.00 the Sunday before black Friday. Have only seen it on sale for $1499.00 since then. All the apps were very intimidating at first but I got used to them very fast. Sometimes I feel as though I have my theater system on, that's how good the sound is. The easiest part was setting it up. Took 30 minutes and I was watching TV. I'm still reading the manual. Can't say enough good things about this TV.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"3\",\n" +
            "      \"message\": \"We definitely wound up with buyers remorse once we got it home and set up. Yes, it is that fraction of a step up from the 55 inch Samsung we purchased a few years ago, but truly, just a fraction better. It is not that WOW you want to yell once you spend twice as much as the same size new best in class TVs that are not the OLED. We definitely go by the new TV's now and just shake our heads at our mistake. Not mad about it, just disappointed in ourselves.\"\n" +
            "    }\n" +
            "  ]\n" +
            "}\n" +
            "     \n";

    public static Facebook facebookComplex(){
        return Facebook.builder()
                .id("1")
                .birthday(new Timestamp(401280850089L))
                .firstname("Luna")
                .lastname("Kling")
                .occupation("Direct Applications Administrator")
                .gender(Gender.female)
                .city(createCity())
                .work("Lebsack - Rippin")
                .friends(asList("68", "38", "122", "115", "127", "128", "91", "82", "31", "53", "32", "65", "76", "87"))
                .school("Walter, Cartwright and Jerde")
                .location("London")
                .relationship("Married")
                .posts(createPosts())
                .build();
    }

    private static City createCity(){
        return City.builder()
                .countryName("United Kingdom")
                .cityName("London")
                .stateName("England")
                .coords(new Coords(-0.12574, 51.50853))
                .build();
    }

    private static List<Map<String,String>> createPosts() {
        List<Map<String,String>> posts = new ArrayList<>();
        final Map<String,String> p1 = new HashMap<>();
        p1.put("id", "1");
        p1.put("message", "Beautiful picture. Curve is nice if you sit within The radius. Nice interface. Enjoyable to watch TV and YouTube as well Netflix. Like the voice recognition software.");
        final Map<String,String> p2 = new HashMap<>();
        p2.put("id", "2");
        p2.put("message", "What a great picture, what great sound.! No more glare.!!!! I love this TV. I bought this on for $1299.00 the Sunday before black Friday. Have only seen it on sale for $1499.00 since then. All the apps were very intimidating at first but I got used to them very fast. Sometimes I feel as though I have my theater system on, that's how good the sound is. The easiest part was setting it up. Took 30 minutes and I was watching TV. I'm still reading the manual. Can't say enough good things about this TV.");
        final Map<String,String> p3 = new HashMap<>();
        p3.put("id", "3");
        p3.put("message", "We definitely wound up with buyers remorse once we got it home and set up. Yes, it is that fraction of a step up from the 55 inch Samsung we purchased a few years ago, but truly, just a fraction better. It is not that WOW you want to yell once you spend twice as much as the same size new best in class TVs that are not the OLED. We definitely go by the new TV's now and just shake our heads at our mistake. Not mad about it, just disappointed in ourselves.");
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
        return posts;
    }


}
