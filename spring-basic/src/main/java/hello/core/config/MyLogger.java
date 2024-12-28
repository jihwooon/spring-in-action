package hello.core.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.UUID;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request")
@Setter
public class MyLogger {

    private String uuid;
    private String requestURL;

    public MyLogger(final String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(final String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init () {
        String uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid +"] request scope bean create:" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid +"] request scope bean create:" + this);
    }
}
