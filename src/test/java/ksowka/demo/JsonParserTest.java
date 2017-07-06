package ksowka.demo;

import ksowka.demo.models.Facebook;
import ksowka.demo.utils.JsonParser;
import org.junit.Test;

import java.io.IOException;

import static ksowka.demo.commons.FacebookObjectMother.FACEBOOK_SIMPLE_AS_STRING;
import static ksowka.demo.commons.FacebookObjectMother.facebookComplex;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JsonParserTest {

    JsonParser jsonParser = new JsonParser();

    @Test
    public void shouldParseToFacebook() throws IOException {
        //given
        String expectedName = "Luna";
        Facebook expected = facebookComplex();

        //when
        final Facebook actual = jsonParser.toFacebook(FACEBOOK_SIMPLE_AS_STRING);

        //then
        assertThat(actual, is(notNullValue()));
        assertThat(actual.getFirstname(), is(equalTo(expectedName)));
        assertThat(actual, is(equalTo(expected)));
    }

}
