package mike.demo.springboot.methodinjection;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.methodinjection.singletonservice.TimerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringBootMethodInjectionApplication {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(SpringBootMethodInjectionApplication.class, args);
        TimerService bean = context.getBean(TimerService.class);
        bean.showMessage();
        Thread.sleep(1000);

        log.info("info...");
        log.debug("debug...");

        bean = context.getBean(TimerService.class);
        bean.showMessage();
    }
}


