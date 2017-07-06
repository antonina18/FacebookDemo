package ksowka.demo;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class JsonParser {

    private final Gson gson;

    public JsonParser() {
        this.gson = new Gson();
    }

    public Facebook toFacebook(String jsonAsString) {
        JsonElement element = gson.fromJson(jsonAsString, JsonElement.class);
        JsonObject jsonObj = element.getAsJsonObject();
        final String id = jsonObj.get("id").getAsString();
        final LocalDate birthday = LocalDateTime.ofInstant(Instant.ofEpochSecond(jsonObj.get("birthday").getAsLong()), ZoneId.of("UTC")).toLocalDate();
        final String firstName = jsonObj.get("firstname").getAsString();
        final String lastName = jsonObj.get("lastname").getAsString();
        final String occupation = jsonObj.get("occupation").getAsString();
        final String gender = jsonObj.get("gender").getAsString();
        final String work = jsonObj.get("work").getAsString();
//        final String friends = jsonObj.get("friends").getAsString();
        final String school = jsonObj.get("school").getAsString();
        final String location = jsonObj.get("location").getAsString();
        final String relationship = jsonObj.get("relationship").getAsString();

        return Facebook.builder()
                .id(id)
                .birthday(birthday)
                .firstname(firstName)
                .lastname(lastName)
                .occupation(occupation)
                .gender(null)
                .work(work)
                .friends(null)
                .school(school)
                .location(location)
                .relationship(relationship)
                .city(null)
                .posts(null)
                .build();
    }
}
