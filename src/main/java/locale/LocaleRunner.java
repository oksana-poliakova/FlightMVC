package locale;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author oksanapoliakova on 26.07.2023
 * @projectName FlightMVC
 */
public class LocaleRunner {
    public static void main(String[] args) {
        Locale locale = new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("GB").build();
//        Locale locale = new Locale("ua", "UA");
        System.out.println(Locale.US);
        System.out.println(Locale.getDefault());

        var translations = ResourceBundle.getBundle("translations", locale);
        System.out.println(translations.getString("page.login.password"));
    }
}
