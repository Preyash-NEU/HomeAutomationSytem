package edu.neu.csye7374.BuilderPattern;


public class Environment {
    private String lightColor;
    private int lightBrightness;
    private Boolean airPurifier;
    private int blindsLevel;
    private String musicType;

    private Environment(Builder builder) {
        this.lightColor = builder.lightColor;
        this.lightBrightness = builder.lightBrightness;
        this.airPurifier = builder.airPurifier;
        this.blindsLevel = builder.blindsLevel;
        this.musicType = builder.musicType;
    }

    public static class Builder {
        private String lightColor;
        private int lightBrightness;
        private Boolean airPurifier;
        private int blindsLevel;
        private String musicType;

        public Builder lightColor(String lightColor) {
            this.lightColor = lightColor;
            return this;
        }

        public Builder lightBrightness(int lightBrightness) {
            this.lightBrightness = lightBrightness;
            return this;
        }

        public Builder airPurifier(Boolean airPurifier) {
            this.airPurifier = airPurifier;
            return this;
        }

        public Builder blindsLevel(int blindsLevel) {
            this.blindsLevel = blindsLevel;
            return this;
        }

        public Builder musicType(String musicType) {
            this.musicType = musicType;
            return this;
        }

        public Environment build() {
            return new Environment(this);
        }
    }

    // getters for all attributes

    public String getLightColor() {
        return lightColor;
    }

    public int getLightBrightness() {
        return lightBrightness;
    }

    public Boolean getAirPurifier() {
        return airPurifier;
    }

    public int getBlindsLevel() {
        return blindsLevel;
    }

    public String getMusicType() {
        return musicType;
    }
}

