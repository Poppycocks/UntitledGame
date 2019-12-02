package ConfigManager;

import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.SystemConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.ConfigurationException;
import java.util.Iterator;


public class ConfigManager {
    private static final Logger log = LogManager.getLogger(ConfigManager.class);
    private static ConfigManager instance = null;
    private final CompositeConfiguration configurations;

    private ConfigManager() {
        configurations = compositeConfigurations();
    }

    public static ConfigManager getInstance() {
        synchronized (ConfigManager.class) {
            if (instance == null) {
                instance = new ConfigManager();
            }
        }
        return instance;
    }

    private CompositeConfiguration compositeConfigurations() {
        CompositeConfiguration config = new CompositeConfiguration();
        config.addConfiguration(new SystemConfiguration());

        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName("usergui.properties"));

        config.addConfiguration(new PropertiesConfiguration());

        Iterator<String> keys = config.getKeys();
        while (keys.hasNext()) {
            String key = keys.next();
            log.debug(key + " = " + config.getProperty(key));
        }
        return config;
    }
}