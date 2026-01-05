import java.util.*;
public class CardGame {

    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;        
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }
    public static String[] shuffleDeck(String[] deck) {
        Random rand = new Random();
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + rand.nextInt(n - i);  
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }
    public static String[][] distributeCards(String[] deck, int numOfCards, int numOfPlayers) {
        if (numOfCards % numOfPlayers != 0) {
            System.out.println("Cannot distribute cards evenly.");
            return new String[0][0];
        }
        String[][] players = new String[numOfPlayers][numOfCards / numOfPlayers];  
        int cardIndex = 0;
        for (int i = 0; i < numOfPlayers; i++) {
            for (int j = 0; j < numOfCards / numOfPlayers; j++) {
                players[i][j] = deck[cardIndex++];
            }
        }
        return players;
    }
    public static void printPlayersCards(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + "'s cards: ");
            for (String card : players[i]) {
                System.out.println(card);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] deck = initializeDeck();
        deck = shuffleDeck(deck);
        System.out.print("Enter the number of players: ");
        int numOfPlayers = scanner.nextInt();
        System.out.print("Enter the number of cards per player: ");
        int numOfCards = scanner.nextInt();
        String[][] players = distributeCards(deck, numOfCards * numOfPlayers, numOfPlayers);
        if (players.length > 0) {
            printPlayersCards(players);
        }
    }
}
