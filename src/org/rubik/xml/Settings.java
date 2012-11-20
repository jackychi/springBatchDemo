package org.rubik.xml;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Settings")
public class Settings {

    private boolean enabled;
//    private TemplateConfig config;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

//    public TemplateConfig getConfig() {
//        return config;
//    }
//
//    public void setConfig(TemplateConfig config) {
//        this.config = config;
//    }

}
