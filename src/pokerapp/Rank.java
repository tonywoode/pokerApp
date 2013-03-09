package pokerapp;

public enum Rank {  
    DEUCE(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    JACK(2,'J'),  
    QUEEN(12, 'Q'),
    KING(13,'K'),
    ACE(14,'A'),
    ACE_LOW(1,'A');
    
    private final int number;
    private final char symbol;
    
    Rank(int number, char symbol) { 
        this.number = number;
        this.symbol = symbol;		
    }  

    Rank(int number) { 
      this(number, (char)('0' + number));
    } 
}