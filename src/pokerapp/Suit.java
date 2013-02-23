package pokerapp;


/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 00:52
 * To change this template use File | Settings | File Templates.
 */
public class Suit {

  private final int number;
  private final char code;

  private Suit(int num, char code) {
    this.number = num;
    this.code = Character.toUpperCase(code);
  }

  public int getNumber() { return number; }
  public char getCode() { return code; }

  public final static Suit Clubs    = new Suit(1, 'C');
  public final static Suit Spades   = new Suit(2, 'S');
  public final static Suit Diamonds = new Suit(3, 'D');
  public final static Suit Hearts   = new Suit(4, 'H');

  public final static Suit[] AllSuits = new Suit[] {
    Clubs, Spades, Diamonds, Hearts
  };

  public static Suit from(char c) throws IllegalArgumentException {
    c = Character.toUpperCase(c);
    for (Suit suit : AllSuits)
      if (suit.getCode() == c)
        return suit;
    throw new IllegalArgumentException("Unknwon suit type: " + c );
  }

  public String toString() {
      return "" + code;
  }
}
