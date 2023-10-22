package infra;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppConfigReader {
    public static JSONObject readAppiumConfig() {
        try {
            // Load the JSON configuration file from the resources folder.
            InputStream inputStream = AppConfigReader.class.getResourceAsStream("/appiumConfig.json");
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuilder jsonContent = new StringBuilder();
            String line;

            // Read the JSON content line by line and append to jsonContent.
            while ((line = streamReader.readLine()) != null) {
                jsonContent.append(line);
            }

            // Parse the JSON content into a JSONObject.
            return new JSONObject(jsonContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions here if needed.
        }
        return null;
    }

}
