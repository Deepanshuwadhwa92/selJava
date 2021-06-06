package util;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesManager extends Properties {

    private static Logger log = LoggerFactory.getLogger(PropertiesManager.class);

    private final List<String> listOfEnv = Arrays.asList("LOCALHOST", "DEV","UAT", "PRD");

    public PropertiesManager() throws IOException {
        String targetEnv = getEnv();
        String fileName = targetEnv+".properties";

        try(FileReader fr =  new FileReader(Paths.get(new URI(this.getClass().getResource(fileName).toString())).toFile())) {
            load(fr);
        } catch (URISyntaxException | FileNotFoundException e) {
            e.printStackTrace();
            log.error("File is Empty. Please check the file: {} on Environment: {}", fileName, targetEnv);
        }
    }

    private String getEnv() {
        try {
            return ObjectUtils.firstNonNull(System.getProperty("env"), System.getProperty("custom_env"), listOfEnv.get(1));
        } catch (NullPointerException e) {
            log.error("Target Environment not specified!, So default to local");
            return listOfEnv.get(1);
        }
    }
}
