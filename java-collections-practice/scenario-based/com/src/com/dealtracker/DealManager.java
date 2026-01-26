package com.dealtracker;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

public class DealManager {

    public static Map<String, Deal> loadDeals(String folderPath) {

        Map<String, Deal> dealMap = new HashMap<>();
        Set<String> seenCodes = new HashSet<>();

        File folder = new File(folderPath);

        for (File file : folder.listFiles()) {
            if (!file.getName().endsWith(".txt")) continue;

            try {
                Deal deal = DealParser.parse(file);

                if (deal.getValidTill().isBefore(LocalDate.now()))
                    continue; // expired

                if (!seenCodes.add(deal.getCode()))
                    continue; // duplicate

                dealMap.put(deal.getCode(), deal);

            } catch (Exception e) {
                // skip invalid deal safely
            }
        }
        return dealMap;
    }

    public static List<Deal> sortByDiscount(
            Collection<Deal> deals) {

        return deals.stream()
                .sorted(Comparator
                        .comparingInt(Deal::getDiscount)
                        .reversed())
                .toList();
    }
}
