package com.training;

public class Properties {

    private static volatile Properties properties;
    private String domainName;
    private String port;
    private String user;

    private Properties() {
        if (properties != null) {
            throw new RuntimeException("Please use getProperties method");
        }
    }

    public static Properties getProperties() {
        if (properties == null) {
            synchronized (Properties.class) {
                if (properties == null) {
                    properties = new Properties();
                }
            }
        }
        return properties;
    }

    public String getDomainName() {
        return "lptraining.com";
    }

    public String getPort() {
        return "8080";
    }

    public String getUser() {
        return "LPT";
    }
 /*       public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUser(String user) {
        this.user = user;
    }*/
}
