package com.pranav.journalApp.api.Response;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component()
public class WeatherResponse {
    private Location location;
    private Current current;


    public class Current{

        @JsonProperty("temp_c")
        private double Temp;

        public double getTemp() {
            return Temp;
        }

        public void setTemp(double temp) {
            Temp = temp;
        }
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public class Location{
        @JsonProperty("name")
        private String name;
        @JsonProperty("region")
        private String region;
        @JsonProperty("country")
        private String country;
        @JsonProperty("localtime")
        private String localtime;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}






