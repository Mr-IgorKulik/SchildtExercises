class Vehicle {
    private int passengers;
    private int fuelCup;
    private int mpg;

    Vehicle(int p, int f, int m) {
        setPassengers(p);
        fuelCup = f;
        mpg = m;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getFuelCup() {
        return fuelCup;
    }

    public void setFuelCup(int fuelCup) {
        this.fuelCup = fuelCup;
    }

    public int getMpg() {
        return mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    int range() {
        return fuelCup * mpg;
    }

    double fuelNeeded(int miles) {
        return (double) miles / mpg;
    }

}

class Truck extends Vehicle {
    private int carGoCap;

    Truck(int p, int f, int m, int c) {
        super(p, f, m);
        setCarGoCap(c);
    }

    public int getCarGoCap() {
        return carGoCap;
    }

    public void setCarGoCap(int carGoCap) {
        this.carGoCap = carGoCap;
    }
}

class TruckDemo {
    public static void main(String[] args) {
        Truck semi = new Truck(2, 200, 7, 44000);
        Truck pickup = new Truck(3, 28, 15, 2000);

        double gallons;
        int dist = 252;

        gallons = semi.fuelNeeded(dist);
        System.out.println("Truck can transport " + semi.getCarGoCap() + " pounds.");
        System.out.println("To overcome " + dist + " miles, the truck needs " + gallons + " gallons of fuel.");

        gallons = pickup.fuelNeeded(dist);
        System.out.println("Pickup can transport " + pickup.getCarGoCap() + " pounds.");
        System.out.println("To overcome " + dist + " miles, the pickup needs " + gallons + " gallons of fuel.");
    }
}