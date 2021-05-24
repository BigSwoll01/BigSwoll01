import java.util.*;
public class Game{ 
    static class Card{ // class that contains card information
    
        private int rank;
        private int suit;
        public Card(int rank, int suit) {
            this.rank = rank;
            this.suit = suit;
        }
    
        public  final String[] RANKS = { "Ace", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Jack", "Queen", "King"};
    
        public  final String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"};
    
        // instance variables and constructors go here
    
        public String toString() {
            return RANKS[this.rank] + " of " + SUITS[this.suit];
        }

        public static int compare(Card on,Card tw) {
            if (on.rank < tw.rank) {
                System.out.println(on.rank + "wins!");
                return -1;
            }
            if (on.rank < tw.rank) {
                System.out.println(tw.rank + "wins!");
                return 1;
            }
            // if (this.suit < that.suit) {
            //     return -1;
            // }
            // if (this.suit > that.suit) {
            //     return 1;
            // }
             return 0;
        }
}
    
    static class Deck{}
public static void main(String[] args) {
    System.out.println("Welcome to Robert's card game\nplease select the number of players");
    Scanner userinput = new Scanner(System.in);
    boolean wenttocatch = false;
int players = 0;
    do{
        if(userinput.hasNextInt()){
            players = userinput.nextInt();
            wenttocatch = true;
        }else{
            userinput.nextLine();
            System.out.println("Enter a valid Integer value");
        }
    }while(!wenttocatch);

    System.out.print("There're "+ players + " players, so each player will have " + 52/players + " cards");
    LinkedList<Card> cardDeck = new LinkedList<Card>(); //create an Deck "cardDeck"
        
        for(int x=0; x<4; x++){          //0-3 for suit (4 suits)
            for(int y=0; y<13; y++){     //2-14 for rank (13 ranks)
                cardDeck.add(new Card(y,x)); //create new card and add into the deck
            } //end rank for
        }//end suit for

        int p1points = 0;
        int p2points = 0;
        
        LinkedList<Card> deck1 = new LinkedList<Card>(); // Player1's linked list
        LinkedList<Card> deck2 = new LinkedList<Card>(); // player2'slinked list
        Collections.shuffle(cardDeck);
        Collections.shuffle(cardDeck); // shuffels twice like in real life

        deck1.addAll(cardDeck.subList(0, 26));              //26 cards for p1       
        deck2.addAll(cardDeck.subList(26, cardDeck.size()));// 26 for p2

        while(true){
        Card p1Card = deck1.pop();  //each plyer removes a card from their deck to cmopare
        Card p2Card = deck2.pop();
            
            //display the face up card
            System.out.println("Player 1 plays card is " + p1Card); //p1Card.suit returns index postion of suit
            System.out.println("Player 2 plays card is " + p2Card);
        
            
        if (p1Card.rank > p2Card.rank){
            System.out.println("Player 1 wins the round");
            p1points += 1;// winner gets their point added to their total
        }
        else if (p1Card.rank < p2Card.rank){
            System.out.println("Player 2 wins the round");
            p2points += 1;
        }
        else if (p1Card.suit > p2Card.suit){
            System.out.println("Player 1 wins the round");
            p1points += 1;
        }
        else if (p1Card.suit < p2Card.suit){
            System.out.println("Player 2 wins the round");
            p2points +=1;
        }
        System.out.println("Player 1 has "+p1points + " points Player 2 has " + p2points + " points");
        if(deck1.size() == 0 ){
            if (p1points > p2points){
            System.out.println("Total: Player 1 has "+p1points + " points Player 2 has " + p2points+ " points");
            System.out.println("game over\nPlayer 1 wins the game");
        }
        else if (p1points < p2points){
            System.out.println("Total: Player 1 has "+p1points + " points Player 2 has " + p2points + " points");
            System.out.println("game over\nPlayer 2 wins the game");
        }
            break;
        } 
    }// end of while loop



    }// end of Main
}

