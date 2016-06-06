package mike.demo.springboot.methodinjection.singletonservice;


import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.methodinjection.model.OperatingSystem;
import mike.demo.springboot.methodinjection.prototypebean.TimerBean;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class TimerService {
    private String dateTimeString = LocalDateTime.now().toString();

    public void showMessage() {
        TimerBean bean = getTimer();
        log.debug(dateTimeString + " :: {}", bean.getDateTime());
    }

    @Lookup
    public TimerBean getTimer() {
        return null;
    }

}
