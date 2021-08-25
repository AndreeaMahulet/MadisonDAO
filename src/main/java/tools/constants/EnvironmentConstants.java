package tools.constants;

import tools.PropertyFileReader;

import java.io.File;

public class EnvironmentConstants {
        public static final String BASE_URL = PropertyFileReader.getEnvConstantsItem("BASE_URL");
        public static final String EMAIL = PropertyFileReader.getEnvConstantsItem("EMAILADDRESS");
        public static final String PASS = PropertyFileReader.getEnvConstantsItem("PASSWORD");
        public static final double CART_TAX_RATE = 0.0825;

        public static final String WEB_DRIVERS_PATH = "src" + File.separator + "test" + File.separator + "resources"
                + File.separator + "drivers" + File.separator;
}
