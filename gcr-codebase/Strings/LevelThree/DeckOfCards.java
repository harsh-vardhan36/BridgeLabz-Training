// Program to create, shuffle and distribute a deck of cards

import java.util.Scanner;

public class DeckOfCards {

    // Method to initialize the deck
    static String[] initializeDeck(String[] suits, String[] ranks) {

        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }

        return deck;
    }

    // Method to shuffle the deck
    static void shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {

            int randomCardNumber = i + (int) (Math.random() * (n - i));

            // Swap cards
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    // Method to distribute cards to players
    static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {

        if (players * cardsPerPlayer > deck.length) {
            return null;
        }

        String[][] playerCards = new String[players][cardsPerPlayer];

        int cardIndex = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerCards[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }

        return playerCards;
    }

    // Method to print players and their cards
    static void printPlayersCards(String[][] playersCards) {

        for (int i = 0; i < playersCards.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + " cards:");
            for (int j = 0; j < playersCards[i].length; j++) {
                System.out.println(playersCards[i][j]);
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        String[] deck = initializeDeck(suits, ranks);

        shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int players = in.nextInt();

        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = in.nextInt();

        String[][] playersCards = distributeCards(deck, players, cardsPerPlayer);

        if (playersCards == null) {
            System.out.println("Cards cannot be distributed with given input.");
        } else {
            printPlayersCards(playersCards);
        }

        in.close();
    }
}
