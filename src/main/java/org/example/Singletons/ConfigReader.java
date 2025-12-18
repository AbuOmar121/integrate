package org.example.Singletons;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private final Properties properties = new Properties();

    private ConfigReader() {
        try (InputStream in =
                     getClass()
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {
            if (in == null) {
                throw new RuntimeException("config.properties not found");
            }
            properties.load(in);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Singleton holder
    private static class Holder {
        private static final ConfigReader INSTANCE = new ConfigReader();
    }

    // Access point
    public static ConfigReader getInstance() {
        return Holder.INSTANCE;
    }

    public String getString(String key) {
        return properties.getProperty(key);
    }
}
