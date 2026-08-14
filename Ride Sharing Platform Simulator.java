import java.util.*;

abstract class Vehicle {
    abstract int calculateFare(int distance);
}

class Bike extends Vehicle {
    int calculateFare(int distance) {
        return distance * 5;
    }
}

class Auto extends Vehicle {
    int calculateFare(int distance) {
        return distance * 12;
    }
}

class Cab extends Vehicle {
    int calculateFare(int distance) {
        return distance * 12;
    }
}

class Driver {
    String name;
    Vehicle vehicle;

    Driver(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }
}

class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

class Trip {
    Rider rider;
    Driver driver;
    int distance;

    Trip(Rider rider, Driver driver, int distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Invalid distance");
        }
        this.rider = rider;
        this.driver = driver;
        this.distance = distance;
    }

    int calculateFare() {
        return driver.vehicle.calculateFare(distance);
    }
}

public class RideSharingPlatformSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Rider rider = new Rider("Rider");

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int distance = sc.nextInt();

            try {
                Vehicle vehicle;

                if (type.equalsIgnoreCase("Bike")) {
                    vehicle = new Bike();
                } else if (type.equalsIgnoreCase("Auto")) {
                    vehicle = new Auto();
                } else if (type.equalsIgnoreCase("Cab")) {
                    vehicle = new Cab();
                } else {
                    throw new IllegalArgumentException("Invalid ride type");
                }

                Driver driver = new Driver("Driver", vehicle);
                Trip trip = new Trip(rider, driver, distance);

                System.out.println(trip.calculateFare());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Booking");
            }
        }

        sc.close();
    }
}