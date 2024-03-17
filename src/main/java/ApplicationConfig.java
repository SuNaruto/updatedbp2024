
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import configuration.JPAConfiguration;

import java.util.HashMap;
import java.util.Map;

@ApplicationPath("/library")
public class ApplicationConfig extends Application {

    @Override
    public Map<String, Object> getProperties() {
        JPAConfiguration.getEntityManager();
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("jersey.config.server.provider.packages", "sr.qualogy.controller");
        return properties;
    }
}