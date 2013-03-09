package pokerapp.basicgame;

import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.console.Driver;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scoredhands.ScoredHand;

import java.util.Scanner;

/**
 * User: ari
 * Date: 09/03/2013
 * Time: 13:37
 * Created with IntelliJ IDEA.
 */
public class CLI_Game {


    public static void main(String[] args) {
      try {

        new Driver().gameLoop();

      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
}





