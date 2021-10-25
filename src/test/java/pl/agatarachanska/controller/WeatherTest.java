package pl.agatarachanska.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;
import pl.agatarachanska.App;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;


@ExtendWith(ApplicationExtension.class)
public class WeatherTest {
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd-MM-yyyy");

    @BeforeAll
    static void beforeAll() throws Exception {
                ApplicationTest.launch(App.class);
           }
   @Test
    void mainDataIsCorrect() {

        //given
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.message");
        String name = new SimpleDateFormat("EEE", Locale.ENGLISH).format(new Date());
        String todayData = createData(name,bundle);
        //when
        //then
       FxAssert.verifyThat("#day", LabeledMatchers.hasText(todayData));
    }

    private String createData(String name, ResourceBundle bundle) {
        Date data = new Date();
        switch (name) {
            case "Mon":
                return bundle.getString("poniedzialek") + " " + FORMATTER.format(data);
            case "Tue":
                return bundle.getString("wtorek") + " " + FORMATTER.format(data);
            case "Wed":
                return bundle.getString("sroda") + " " + FORMATTER.format(data);
            case "Thu":
                return bundle.getString("czwartek") + " " + FORMATTER.format(data);
            case "Fri":
                return bundle.getString("piatek") + " " + FORMATTER.format(data);
            case "Sat":
                return bundle.getString("sobota") + " " + FORMATTER.format(data);
            case "Sun":
                return bundle.getString("niedziela") + " " + FORMATTER.format(data);
        }
        return "brak";
    }
}
