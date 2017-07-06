package ksowka.demo;

import org.junit.Test;

import static ksowka.demo.commons.FacebookObjectMother.facebookWithFirstName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class JsonParserTest {

    JsonParser jsonParser = new JsonParser();

    @Test
    public void shouldParseToFacebook(){
        //given
        String expectedName = "Luna";
        Facebook expected = facebookWithFirstName(expectedName);

        //when
        final Facebook actual = jsonParser.toFacebook("{\n" +
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
                "     \n");

        //then
        assertThat(actual, is(notNullValue()));
        assertThat(actual.getFirstname(), is(equalTo(expectedName)));
        assertThat(actual, is(equalTo(expected)));
    }

}
