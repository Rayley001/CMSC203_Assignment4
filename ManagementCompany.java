public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    private String name;
    private String taxID;
    private double mgmFee;

    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    public ManagementCompany() {
        this("", "", 0.0, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee,
                             int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(x, y, width, depth);
        this.numberOfProperties = 0;
    }

    // Copy constructor
    public ManagementCompany(ManagementCompany other) {
        if (other == null) {
            this.name = "";
            this.taxID = "";
            this.mgmFee = 0.0;
            this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
            this.properties = new Property[MAX_PROPERTY];
            this.numberOfProperties = 0;
        } else {
            this.name = other.name;
            this.taxID = other.taxID;
            this.mgmFee = other.mgmFee;
            this.plot = new Plot(other.plot);
            this.properties = new Property[MAX_PROPERTY];
            this.numberOfProperties = 0;
            for (int i = 0; i < other.numberOfProperties; i++) {
                this.properties[i] = new Property(other.properties[i]);
                this.numberOfProperties++;
            }
        }
    }

    public String getName() { return name; }
    public String getTaxID() { return taxID; }
    public double getManagementFee() { return mgmFee; }
    public Plot getPlot() { return new Plot(plot); }

    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }

    public boolean isManagementFeeValid() {
        return mgmFee >= 0 && mgmFee <= 100;
    }

    public int addProperty(Property property) {
        if (isPropertiesFull()) return -1;
        if (property == null) return -2;
        if (!plot.encompasses(property.getPlot())) return -3;

        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }

        properties[numberOfProperties] = new Property(property);
        numberOfProperties++;
        return numberOfProperties - 1;
    }

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner,
                           int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public double getTotalRent() {
        double total = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;
        int maxIndex = 0;
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > properties[maxIndex].getRentAmount()) {
                maxIndex = i;
            }
        }
        return new Property(properties[maxIndex]);
    }

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("List of the properties for ").append(name)
          .append(", taxID: ").append(taxID).append("\n");

        sb.append("______________________________________________________\n");

        for (int i = 0; i < numberOfProperties; i++) {
            sb.append(properties[i].toString()).append("\n");
        }

        sb.append("______________________________________________________\n");
        sb.append("\n");

        double totalFee = getTotalRent() * (mgmFee / 100.0);
        sb.append(" total management Fee: ").append(String.format("%.2f", totalFee));

        return sb.toString();
    }
}