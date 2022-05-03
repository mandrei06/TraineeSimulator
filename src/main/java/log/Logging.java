package log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import start.Starter;

public class Logging {
    private static final Logger logger = LogManager.getLogger(Starter.class);

    public static void traceLog(String message) {
        logger.trace(message);
    }

    public static void errorLog(String message) {
        logger.error(message);
    }

    public static void infoLog(String message) {
        logger.info(message);
    }

    public static void debugLog(String message) {
        logger.debug(message);
    }

    public static void warnLog(String message){ logger.warn(message);}

    public static void fatalLog(String message){ logger.fatal(message);}

}
