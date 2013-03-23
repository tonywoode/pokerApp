package tests;

import pokerapp.HandFactory;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scorers.HandScorer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 23/03/13
 * Time: 22:02
 * To change this template use File | Settings | File Templates.
 */
public class ManualTester {
    static public void main(String[] args) throws IOException {
        HandScorerBuilder buildHand = new HandScorerBuilder();
        HandFactory handFactory = new HandFactory();
        HandScorer handScorerChain = buildHand.create();

        System.out.println("Enter a card string: ");

        Scanner input = new Scanner( System.in );

                while(input.hasNext()){
                    try {
                String cardList = input.next();
                System.out.println(handScorerChain.score(handFactory.createFromLine(cardList)).getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }
