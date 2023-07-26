package locale;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author oksanapoliakova on 26.07.2023
 * @projectName FlightMVC
 */
public class LocaleRunner {
    public static void main(String[] args) {
        Locale locale = new Locale.Builder().setLanguage("uk").setScript("Cyrl").setRegion("UA").build();

        var translations = ResourceBundle.getBundle("translations", locale);
    }
}
