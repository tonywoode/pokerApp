package pokerapp;


import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 00:52
 * To change this template use File | Settings | File Templates.
 */
public class Suit {

  private final int number;

  private Suit(int num) {
    number = num;
  }

  public int getNumber() { return number; }

  public final static Suit Clubs    = new Suit(1);
  public final static Suit Spades   = new Suit(2);
  public final static Suit Diamonds = new Suit(3);
  public final static Suit Hearts   = new Suit(4);

  public static Suit from(char c) throws InvalidArgumentException {
    switch(Character.toLowerCase(c)) {
      case 'c': return Clubs;
      case 'd': return Diamonds;
      case 'h': return Hearts;
      case 's': return Spades;
    }
    throw new InvalidArgumentException(new String[] { "Unknwon suit type: " + c });
  }

}
