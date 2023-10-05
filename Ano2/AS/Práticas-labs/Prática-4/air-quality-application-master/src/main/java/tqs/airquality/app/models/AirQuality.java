package tqs.airquality.app.models;

import lombok.Getter;
import lombok.ToString;
import tqs.airquality.app.utils.Location;

import java.sql.Date;

@Getter
@ToString
public class AirQuality {

    private Long id;
    private Location location;
    private Date dt;

    private double co;
    private double no;
    private double no2;
    private double o3;
    private double so2;
    private double pm25;
    private double pm10;
    private double nh3;

    public AirQuality(Location location,
                      Date dt,
                      double co,
                      double no,
                      double no2,
                      double o3,
                      double so2,
                      double pm25,
                      double pm10,
                      double nh3) {
        this.location = location;
        this.dt = dt;
        this.co = co;
        this.no = no;
        this.no2 = no2;
        this.o3 = o3;
        this.so2 = so2;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.nh3 = nh3;
    }
}
