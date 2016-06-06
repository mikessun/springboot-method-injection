package mike.demo.springboot.methodinjection.singletonservice;

import mike.demo.springboot.methodinjection.model.OperatingSystem;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class OperatingSystemService {

    public String processOperatingSystem(){
        return getOperatingSystem().getOperatingSystemKernel();
    }

    @Lookup
    public OperatingSystem getOperatingSystem() {
        return null;
    }
}
