package pokerapp.console;

import lombok.Getter;
import lombok.Setter;

/**
 * @author   Ari
 * @version  1.0
 * @param    //TODO:Parameter Description
 */
public class ExchangeSetting {

  @Getter @Setter private int numCards;
  @Getter @Setter private int numTimes;

  public ExchangeSetting(int numCards, int numTimes){
    this.numCards = numCards;
    this.numTimes = numTimes;
  }

}