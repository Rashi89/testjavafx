package pl.agatarachanska.model;

import org.junit.jupiter.api.Test;
import pl.agatarachanska.model.WeatherTool;

import java.util.ResourceBundle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.willThrow;

public class WeatherToolTest {

    @Test
    void newWeatherToolSetCityName() {
        //given
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.message");
        WeatherTool weatherTool = new WeatherTool("Kraków", bundle);
        //when
        String city = weatherTool.getCity();
        //then
        assertThat(city,equalTo("Kraków"));
    }

}
