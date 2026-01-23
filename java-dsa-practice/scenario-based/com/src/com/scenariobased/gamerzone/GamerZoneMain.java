package com.scenariobased.gamerzone;

public class GamerZoneMain {

    public static void main(String[] args) {

        Player[] players = {
            new Player("ShadowX", 1800),
            new Player("NovaKnight", 3200),
            new Player("PixelPro", 2400),
            new Player("AceGamer", 2900),
            new Player("Blaze", 1500)
        };

        QuickSortUtil.quickSort(players, 0, players.length - 1);

        System.out.println("Global Leaderboard:");
        for (Player p : players) {
            System.out.println(p.username + " -> " + p.score);
        }
    }
}
