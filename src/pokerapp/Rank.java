package pokerapp;

import lombok.Getter;

/**
 * Describes ranks, assigns each rank name a value, and allows printing to screen of the rank - it was decided that 10 is 10, Jack is J, King K, Queen Q and Ace A or 1
 * @author Tony
 * 
 */

public enum Rank {  
    DEUCE(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(2,"J"),  
    QUEEN(12, "Q"),
    KING(13,"K"),
    ACE(14,"A"),
    ACE_LOW(1,"A");
    
    @Getter private int number;
    @Getter private String symbol;

    /**
     * @param number rank of cards 1 to 10
     * @param symbol necessary for jack, queen, king, ace
     * @throws IllegalArguementException in case constructor receives a second argument that's not ten to ace 
     */
    Rank(int number, String symbol) { //ENUM constructors are private
        this.number = number;
        this.symbol = symbol;
        
        if ( ( symbol.length() > 1) && ( ! symbol.equals("10") ) ) { //if >= 2 digits and It's NOT a 10
        	throw new IllegalArgumentException("Invalid Symbol, that's not a card rank");
        }
    }  

    /**
     * Even cards <11 need two parameters, we pass the number as the second for card ranks <11
     * @param number
     */
    Rank(int number) { 
      this( number, Integer.toString(number) );
    } 
    
      
    
    /**
     * Returns the Rank in a form that can be printed onscreen
     * @throws IllegalArgumentException because it won't be a rank
     */
    //TODO: anyone know a better way than a switch? How can you do a toString() when you need a toString() on the ENUM class to do so...
    @Override
    public String toString() {   
    	switch(this) {
    	case DEUCE: return "Deuce";
    	case THREE: return "Three";
    	case FOUR: return "Four";
    	case FIVE: return "Five";
    	case SIX: return "Six";
    	case SEVEN: return "Seven";
    	case EIGHT: return "Eight";
    	case NINE: return "Nine";
    	case TEN: return "Ten";
    	case JACK: return "Jack";
    	case QUEEN: return "Queen";
    	case KING: return "King";
    	case ACE: return "Ace";
    	case ACE_LOW: return "Low Ace";
    	default: throw new IllegalArgumentException();
    	}
    }
    
}