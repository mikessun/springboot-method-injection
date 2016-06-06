package mike.demo.springboot.methodinjection.config;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.methodinjection.annotation.OperatingSystemQualifier;
import mike.demo.springboot.methodinjection.model.OperatingSystem;
import mike.demo.springboot.methodinjection.model.OperatingSystemLinux;
import mike.demo.springboot.methodinjection.model.OperatingSystemWindows;
import mike.demo.springboot.methodinjection.prototypebean.TimerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

@Configuration
@Slf4j
public class OperatingSystemFactory {
    private int count = 0;
    @Autowired
    @OperatingSystemQualifier(OperatingSystemQualifier.OperatingSystems.Windows)
    private OperatingSystem win;
    @Autowired
    @OperatingSystemQualifier(OperatingSystemQualifier.OperatingSystems.Linux)
    private OperatingSystem linux;


    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Primary
    public OperatingSystem getOperatingSystem() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        log.warn("IN getOperatingSystem {}", timeInMillis);
        log.info("count==" + timeInMillis);
        if (timeInMillis % 2 == 0) {
            return win;
        }
        return linux;
    }
}
