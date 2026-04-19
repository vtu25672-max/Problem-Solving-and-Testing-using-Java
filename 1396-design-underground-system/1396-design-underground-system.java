import java.util.*;

class UndergroundSystem {
    // Map to store check-in info: id -> (stationName, time)
    private Map<Integer, Pair> checkIns;
    // Map to store route info: "startStation->endStation" -> (totalTime, tripCount)
    private Map<String, RouteStats> routeStats;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routeStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair checkInData = checkIns.get(id);
        checkIns.remove(id);

        String routeKey = checkInData.station + "->" + stationName;
        int travelTime = t - checkInData.time;

        RouteStats stats = routeStats.getOrDefault(routeKey, new RouteStats());
        stats.totalTime += travelTime;
        stats.tripCount++;
        routeStats.put(routeKey, stats);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteStats stats = routeStats.get(routeKey);
        return (double) stats.totalTime / stats.tripCount;
    }

    // Helper class for check-in data
    private static class Pair {
        String station;
        int time;
        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Helper class for route statistics
    private static class RouteStats {
        int totalTime;
        int tripCount;
    }
}
