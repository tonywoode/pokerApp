package pokerapp.console.strategies;

import pokerapp.Card;
import pokerapp.scorer.domain.Spares;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 11/03/13
 * Time: 23:56
 * To change this template use File | Settings | File Templates.
 * This is an implemetation of the strategy pattern
 */
    public interface IStrategy {

       String makeDecision(StringBuilder commandBuilder, ArrayList<Card> sortedCards);

       double calculateProbability();

       Spares nonRelevantCards();
    }
