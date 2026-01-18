package com.geomeasure;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Line> lines = new ArrayList<>();

        System.out.print("How many lines you want to compare? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter coordinates for Line " + i);
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();

            Line line = new Line(x1, y1, x2, y2);
            lines.add(line);
        }

        if (lines.size() >= 2) {
            Line l1 = lines.get(0);
            Line l2 = lines.get(1);

            double len1 = l1.getLength();
            double len2 = l2.getLength();

            System.out.println("\nLine 1 Length: " + len1);
            System.out.println("Line 2 Length: " + len2);

            if (len1 == len2) {
                System.out.println("✅ Both lines are equal in length.");
            } else if (len1 > len2) {
                System.out.println("📏 Line 1 is longer.");
            } else {
                System.out.println("📐 Line 2 is longer.");
            }
        }
    }
}
