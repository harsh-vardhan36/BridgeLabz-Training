package com.java8.stream.insuranceclain;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        List<Claim> claims = List.of(
            new Claim("Health", 50000),
            new Claim("Vehicle", 20000),
            new Claim("Health", 70000),
            new Claim("Life", 100000),
            new Claim("Vehicle", 30000)
        );

        Map<String, Double> averageClaimAmount =
                claims.stream()
                      .collect(Collectors.groupingBy(
                          Claim::getClaimType,
                          Collectors.averagingDouble(Claim::getAmount)
                      ));

        averageClaimAmount.forEach((type, avg) ->
            System.out.println(type + " → Average Amount: " + avg)
        );
    }
}
