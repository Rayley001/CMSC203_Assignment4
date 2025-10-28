public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
        this.plot = new Plot(0,0,1,1);
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(0,0,1,1);
    }

    public Property(String propertyName, String city, double rentAmount, String owner,
                    int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    // Copy constructor
    public Property(Property other) {
        this.propertyName = other.propertyName;
        this.city = other.city;
        this.rentAmount = other.rentAmount;
        this.owner = other.owner;
        this.plot = new Plot(other.plot);
    }

    public Plot getPlot() {
        return new Plot(plot);
    }

    public String getPropertyName() { return propertyName; }
    public String getCity() { return city; }
    public double getRentAmount() { return rentAmount; }
    public String getOwner() { return owner; }

    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}