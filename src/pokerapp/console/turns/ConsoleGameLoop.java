package pokerapp.console.turns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pokerapp.*;
import pokerapp.console.Console;
import pokerapp.console.ExchangeSetting;
import pokerapp.scorer.PokerGameEvaluator;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements a game loop for the console.
 *
 * Uses the visitor pattern to enable different
 * decisions for InteractivePlayers and ComputerPlayers
 *
 * @author Steve
 * @version 1
 */
@RequiredArgsConstructor
public class ConsoleGameLoop implements PlayerVisitor {
  private final PokerGameEvaluator pokerGameEvaluator;

  @Getter @Setter
  private ExchangeSetting exchangeSetting = ExchangeSetting.Default;
  private final List<ConsolePlayerTurn> turns = new ArrayList<>();

  public void register(InteractivePlayer ip) {
    turns.add(new InteractivePlayerTurn(ip, exchangeSetting));
  }

  public void register(ComputerPlayer cp) {
    turns.add(new ComputerPlayerTurn(cp, exchangeSetting, pokerGameEvaluator));
  }

  public void play(Dealer dealer, Console console) {
    for (int iter = 0; iter < exchangeSetting.getNumTimes(); ++iter) {
      for (ConsolePlayerTurn turn : turns) {
        turn.playTurn(dealer, console);
      }
    }
  }

  public void register(Players players) {
    for (Player player : players)
      player.visit(this);
  }

  @Override
  public void accept(InteractivePlayer interactivePlayer) {
    register(interactivePlayer);
  }

  @Override
  public void accept(ComputerPlayer computerPlayer) {
    register(computerPlayer);
  }

  public ConsoleGameLoop reset() {
    turns.clear();
    return this;
  }
}