package fileHandlingandStreams;
import java.util.HashSet;

//Route Planner Interface
interface RoutePlanner {
 HashSet<String> planRoute(String start, String end);
}

class FlightRoutePlanner implements RoutePlanner {
 private HashSet<String> waypoints = new HashSet<>();

 public FlightRoutePlanner() {
     // Customize waypoints
     waypoints.add("California");
     waypoints.add("Berkeley");
     waypoints.add("Alaska");
 }

 @Override
 public HashSet<String> planRoute(String start, String end) {
     HashSet<String> route = new HashSet<>();

     if (waypoints.contains(start) && waypoints.contains(end)) {
         route.add(start);
         route.add(end);
     } else {
         System.out.println("Invalid route.");
     }

     return route;
 }
}

public class RoutePlannerDemo {
 public static void main(String[] args) {
     RoutePlanner planner = new FlightRoutePlanner();

     // Example route planning
     HashSet<String> route = planner.planRoute("California", "Alaska");
     System.out.println("Route: " + route);

     route = planner.planRoute("Berkeley", "Alaska");
     System.out.println("Route: " + route);

     route = planner.planRoute("Berkeley", "Huwaweei"); // Invalid route
 }
}
