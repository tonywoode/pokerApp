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

  public static ExchangeSetting Default = new ExchangeSetting(3, 1);

  public ExchangeSetting(int numCards, int numTimes) {
    this.numCards = numCards;
    this.numTimes = numTimes;
  }

}