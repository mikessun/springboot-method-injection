package mike.demo.springboot.methodinjection.config;

import mike.demo.springboot.methodinjection.prototypebean.TimerBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TimerBeanFactory {
    @Value("${prototype.name: myname}")
    private String name;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public TimerBean prototypeBean() {
        return new TimerBean(name);
    }
}
