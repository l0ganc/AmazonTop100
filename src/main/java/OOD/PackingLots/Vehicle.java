package OOD.PackingLots;

import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    protected int spotsNeeded;
    protected VehicleSize size;
    protected String licensePlate;   // id for a vehicle

    protected List<ParkingSpot> parkingSpots = new ArrayList<>();

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void clearSpots() {
        for (int i = 0; i < parkingSpots.size(); i++) {
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }

    //this need to be implement in subclass
    public abstract boolean canFitInSpot(ParkingSpot spot);
    public abstract void print();
}
