package com.java8.workshop.foreach;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<LiveSchedule> liveSchedules = Arrays.asList(
            new LiveSchedule("Bus", "Route 12", "09:10 AM"),
            new LiveSchedule("Metro", "Line A", "09:12 AM"),
            new LiveSchedule("Taxi", "Airport", "Now")
        );

        // forEach() to push live updates to dashboard
        liveSchedules.forEach(DashboardService::display);
    }
}
