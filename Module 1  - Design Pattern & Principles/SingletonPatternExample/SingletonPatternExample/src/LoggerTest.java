import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;


public class LoggerTest {

    @Test
    void test() {
            Logger log1 = Logger.getLogger();
            Logger log2 = Logger.getLogger();

            assertSame(log1, log2);
        }
}