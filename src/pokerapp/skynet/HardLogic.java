package pokerapp.skynet;

import lombok.Setter;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Player;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 30/03/13
 * Time: 19:46
 * To change this template use File | Settings | File Templates.
 */
public class HardLogic implements LogicBridge {

    @Setter
    private Player player;

    public HardLogic(Player player)
    {
        this.player = player;
    }

    public ArrayList<Card> getNearStraightRemoval(int index)
    {
        int removalSize = index;
        Hand hand = player.getHand();
        ArrayList<Card> sortedCards = hand.getSortedCards();
        ArrayList<Card> relevantCards = new ArrayList<>();
        int targetSize = HANDSIZE - index;


        for(int i= 0; i < sortedCards.size() && index >= 0 && relevantCards.size() < targetSize; i++)
        {
            for (int j = i+1; j < sortedCards.size(); j++)
            {
                int compareRanks = Math.abs(sortedCards.get(i).getRank().getNumber()
                        - sortedCards.get(j).getRank().getNumber());
                if(compareRanks == 1 ||
                        (sortedCards.get(i).getRank().getNumber() == 2
                                && sortedCards.get(j).getRank().getNumber() == 14))
                {
                    relevantCards.add(sortedCards.get(i));
                    if(j < sortedCards.size() - 1)
                        if(Math.abs(sortedCards.get(j).getRank().getNumber()
                                - sortedCards.get(j+1).getRank().getNumber()) != 1)
                            relevantCards.add(sortedCards.get(j));

                    if((relevantCards.size() + 1 == targetSize))
                        relevantCards.add(sortedCards.get(j));
                    break;
                }
                else
                {
                    if(compareRanks <= index ||
                            (sortedCards.get(i).getRank().getNumber() <= 2 + index
                                    && sortedCards.get(j).getRank().getNumber() == 14 ))
                    {
                        index -= compareRanks;
                        relevantCards.add(sortedCards.get(i));
                        break;
                    }
                }
            }
        }

        sortedCards.removeAll(relevantCards);

        if((relevantCards != null ? relevantCards.size() : 0) >= targetSize && sortedCards.size() == removalSize && index >= 0)
            return sortedCards;
        else
            return null;
    }


    public ArrayList<Card> getNearFlushRemoval(int index)
    {
        Hand hand = player.getHand();
        ArrayList<Card> sortedCards = hand.getSortedCards();

        return null;
    }

    public Boolean hasOtherPlayerMoved()
    {
        return player.getHistoryTable().isPlayerMoved();
    }

}
