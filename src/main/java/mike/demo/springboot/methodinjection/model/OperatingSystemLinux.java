package mike.demo.springboot.methodinjection.model;

import mike.demo.springboot.methodinjection.annotation.OperatingSystemQualifier;
import org.springframework.context.annotation.Primary;

import javax.inject.Named;

@Named
@OperatingSystemQualifier(OperatingSystemQualifier.OperatingSystems.Linux)
public class OperatingSystemLinux implements OperatingSystem {
    @Override
    public String getOperatingSystemKernel() {
        return "Linux Kernel 3.10";
    }
}
