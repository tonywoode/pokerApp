package pokerapp.console;

import lombok.Getter;
import lombok.Setter;

/**
 * @author   Ari
 * @version  1.0
 */
public class ExchangeSetting {

  @Getter @Setter private int numCards;
  @Getter @Setter private int numTimes;
  public static int DEFAULT_NUM_CARDS = 3;
  public static int DEFAULT_NUM_TURNS = 1;
  public static ExchangeSetting Default = new ExchangeSetting(DEFAULT_NUM_CARDS, DEFAULT_NUM_TURNS);

  public ExchangeSetting(int numCards, int numTimes) {
    this.numCards = numCards;
    this.numTimes = numTimes;
  }

}