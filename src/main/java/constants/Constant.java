package constants;

import java.time.Duration;

public class Constant {
    public static class TimeoutVariable {
        public static final int IMPLICIT_WAIT = 4;
        public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(10);
        public static final int WAITING_TIME = 3000;
    }

    public static class Urls {
        public static final String START_PAGE = "https://ru.wikipedia.org/wiki/Москва";
    }

    public static class Browsers {
        public static final String EDGE_BROWSER = "Edge";
        public static final String CHROME_BROWSER = "Chrome";
        public static final String FIREFOX_BROWSER = "Firefox";
    }
}
