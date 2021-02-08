package com.training.broadband;

public class BroadbandPackage {
    private final String name;
    private final String nic;
    private final String basePackage;
    private final String entertainmentPackage;
    private final String socialMediaPackage;
    private final String workFromHomePackage;

    public BroadbandPackage(PackageBuilder packageBuilder) {
        this.name = packageBuilder.name;
        this.nic = packageBuilder.nic;
        this.basePackage = packageBuilder.basePackage;
        this.entertainmentPackage = packageBuilder.entertainmentPackage;
        this.socialMediaPackage = packageBuilder.socialMediaPackage;
        this.workFromHomePackage = packageBuilder.workFromHomePackage;
    }

    static class PackageBuilder {
        private String name;
        private String nic;
        private String basePackage;
        private String entertainmentPackage;
        private String socialMediaPackage;
        private String workFromHomePackage;

        public PackageBuilder(String name, String nic, String basePackage) {
            this.name = name;
            this.nic = nic;
            this.basePackage = basePackage;
        }

        public PackageBuilder entertainmentPackage(String entertainmentPackage) {
            this.entertainmentPackage = entertainmentPackage;
            return this;
        }

        public PackageBuilder socialMediaPackage(String socialMediaPackage) {
            this.socialMediaPackage = socialMediaPackage;
            return this;
        }

        public PackageBuilder workFromHomePackage(String workFromHomePackage) {
            this.workFromHomePackage = workFromHomePackage;
            return this;
        }

        public BroadbandPackage build() {
            return new BroadbandPackage(this);
        }
    }

    @Override
    public String toString() {
        return "BroadbandPackage{" +
                "name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", basePackage='" + basePackage + '\'' +
                ", entertainmentPackage='" + entertainmentPackage + '\'' +
                ", socialMediaPackage='" + socialMediaPackage + '\'' +
                ", workFromHomePackage='" + workFromHomePackage + '\'' +
                '}';
    }
}
