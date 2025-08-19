package resources;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "userData" , parallel = true)
    public static Object[][] getData() {
        Object[][] data = {
                {"Arun", "Kumar", "Jahangirabad", "Indarpuri", "Bhopal", "462008", "India", "Madhya Pradesh"},

        };
        return data;

    }
}
