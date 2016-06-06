package mike.demo.springboot.methodinjection.model;

import mike.demo.springboot.methodinjection.annotation.OperatingSystemQualifier;

import javax.inject.Named;

@Named
@OperatingSystemQualifier(OperatingSystemQualifier.OperatingSystems.Windows)
public class OperatingSystemWindows implements OperatingSystem {
    @Override
    public String getOperatingSystemKernel() {
        return "x86";
    }
}
