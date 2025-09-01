package fileHandlingandStreams;

import java.io.*;
import java.util.*;

// Interface for Plane Management
interface PlaneManagement {
    void addPlane(String planeName, String planeType);
    void removePlane(String planeName);
    void listPlanes();
}

// Flight Management System
class FlightManagementSystem implements PlaneManagement {
    private Map<String, String> planes = new HashMap<>();

    @Override
    public void addPlane(String planeName, String planeType) {
        planes.put(planeName, planeType);
        System.out.println("Added Plane: " + planeName + " (Type: " + planeType + ")");
    }

    @Override
    public void removePlane(String planeName) {
        if (planes.containsKey(planeName)) {
            planes.remove(planeName);
            System.out.println("Removed Plane: " + planeName);
        } else {
            System.out.println("Plane not found: " + planeName);
        }
    }

    @Override
    public void listPlanes() {
        System.out.println("Planes in the system:");
        for (Map.Entry<String, String> entry : planes.entrySet()) {
            System.out.println("Name: " + entry.getKey() + " | Type: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        FlightManagementSystem fms = new FlightManagementSystem();
        fms.addPlane("Plane1", "Passenger");
        fms.addPlane("Plane2", "Cargo");
        fms.listPlanes();

        // Handling Sensor Data for Cockpit
        byte[] sensorData = { 0x12, 0x34, 0x56, 0x78 };
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(sensorData);
            byte[] receivedData = byteArrayOutputStream.toByteArray();
            
            System.out.println("Received Sensor Data:");
            for (byte data : receivedData) {
                System.out.println("Sensor Data: " + data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Dynamic Flight Plan Generation
        StringBuilder flightPlan1 = new StringBuilder("Flight Plan for Plane1: ");
        flightPlan1.append("Departure -> Waypoint 1 -> Waypoint 2 -> Destination");
        
        StringBuilder flightPlan2 = new StringBuilder("Flight Plan for Plane2: ");
        flightPlan2.append("Departure -> Waypoint X -> Waypoint Y -> Destination");
        
        System.out.println(flightPlan1.toString());
        System.out.println(flightPlan2.toString());

        // Database Integration (Adapter Classes not shown here)
        // Route Planner Interface with HashSet (not shown here)
    }
}

