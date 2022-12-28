package core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;

public class ConfigReader {

    public ApplicationConfig ConfigReader()
    {
        File file = new File("config/database.yaml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ApplicationConfig config = null;
        try {
            config = objectMapper.readValue(file, ApplicationConfig.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Application config info " + config.toString());
        return config;
    }

}

