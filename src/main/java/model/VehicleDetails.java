package model;

public class VehicleDetails {

    private String make;
    private String model;
    private String year;
    private String value;

    public VehicleDetails(String make, String model, String year, String value) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.value = value;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "VehicleDetails{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
