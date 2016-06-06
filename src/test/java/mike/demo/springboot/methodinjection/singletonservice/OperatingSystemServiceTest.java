package mike.demo.springboot.methodinjection.singletonservice;

import lombok.extern.slf4j.Slf4j;
import mike.demo.springboot.methodinjection.SpringBootMethodInjectionApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.OutputCapture;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
@Slf4j
public class OperatingSystemServiceTest {
    private OperatingSystemService operatingSystemService;
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    @Before
    public void before() {
        this.context.register(SpringBootMethodInjectionApplication.class);
        this.context.refresh();
        operatingSystemService = this.context.getBean(OperatingSystemService.class);
    }

    @After
    public void closeContext() {
        this.context.close();
    }

    @Test
    public void testProcessOperatingSystemWin() throws Exception {
        log.info("INFO called");
        log.debug("DEBUG called");
        log.warn("WARN called");
        assertThat(operatingSystemService.processOperatingSystem()).isEqualTo("x86");
    }

    @Rule
    public OutputCapture outputCapture = new OutputCapture();
    @Test
    public void testLoadedCustomLogbackConfig() throws Exception {
        SpringBootMethodInjectionApplication.main(new String[0]);
        this.outputCapture.expect(containsString("x86"));
        this.outputCapture.expect(not(containsString("Linux")));
    }
}