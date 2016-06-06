package mike.demo.springboot.methodinjection.prototypebean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class TimerBean {

    private String dateTimeString = LocalDateTime.now().toString();

    private String name;

    public TimerBean(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return name + " @ " + dateTimeString;
    }
}
