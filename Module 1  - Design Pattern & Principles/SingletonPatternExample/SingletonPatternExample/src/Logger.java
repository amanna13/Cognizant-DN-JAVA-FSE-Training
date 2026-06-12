public class Logger {

    private Logger() {
    }

    private static final Logger instance = new Logger();

    public static Logger getLogger() {
        return instance;
    }
}
