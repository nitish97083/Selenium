


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class LogTest {


    public static Logger logger = LogManager.getLogger(LogTest.class.getName());


    public static void loggerTest() {
        System.out.println(logger);
        logger.info("This is my first log4j's statement");

        int a = 10;
        int b = 12;
        int d = 0;
        int c = a * b;
        //logger.traceEntry();
        logger.debug("message ", c);
        logger.debug("out this ");
        try {
            logger.error("Exception block", a / d);

        } catch (ArithmeticException e) {
            logger.info("catch block ");
        } finally {


            logger.info("This is my first log4j's statement");
        }
    }

    public static void main(String[] args) throws IOException {

        // String log4jConfPath = "C:/code/automation-projects/Facebook/logs/logs.log";
        // PropertyConfigurator.configure(log4jConfPath);
        //BasicConfigurator.configure();
        FileInputStream ip = new FileInputStream("C:/code/automation-projects/Facebook/" +
                "src/main/resources/config.properties");
        Properties prop = new Properties();
        prop.load(ip);
        logger.error("This is error log");
        logger.trace("this is trace error ");
        System.out.println(prop.getProperty("password"));
        logger.debug(prop.getProperty("DRIVER_PATH"));
        loggerTest();
        System.out.println(" Method call");
    }
}


