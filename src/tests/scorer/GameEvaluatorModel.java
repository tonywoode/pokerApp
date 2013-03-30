package tests.scorer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pokerapp.Deck;
import pokerapp.Hand;
import pokerapp.HandFactory;
import pokerapp.Player;
import pokerapp.console.Console;
import pokerapp.console.ExchangeSetting;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * Detailed explanation of the class and its collaborators.
 * </p>
 * <p>
 * Describe whether the class uses/is part of a pattern.
 * </p>
 * <p>
 * Examples of use, if particularly complex
 * </p>
 *
 * @author Steve
 * @version 1
 */
@AllArgsConstructor
public class GameEvaluatorModel {
  @Getter private final Player winner;
  @Getter private final List<Player> players;

  public static List<GameEvaluatorModel> load(String path, Object classpathContext) throws IOException {
    return load(path, classpathContext.getClass());
  }

  public static List<GameEvaluatorModel> load(String path, Class type) throws IOException {
    List<GameEvaluatorModel> list = new ArrayList<>();
    BufferedReader br = null;
    String line;

    try {
      br = new BufferedReader(new InputStreamReader(type.getResourceAsStream(path)));
      while ((line = br.readLine()) != null)
        list.add(parse(line));
    } finally {
      if (br != null)
        br.close();
    }

    return list;
  }

  public static GameEvaluatorModel parse(String line) {
    // 1|H3 D3 S3 S5 S8|H2 C8 C3 C5 C8 -- player 1 wins with three of a kind (rank 3)

    //line = line.replace("--.*", "").trim();

    int p = line.indexOf("--");
    if (p == 0)
      return null; // entire line comment
    else if (p != -1)
      line = line.substring(0, p - 1);

    line = line.trim();

    if (line.length() == 0)
      return null;

    String[] parts = line.split("\\|");

    int winnerIndex = parseWinner(parts[0]); // -1 for tie

    HandFactory handFactory = new HandFactory();

    List<Player> players = new ArrayList<>();
    int iter = 1;
    for (String hand : new IteratorExtensions<String>().from(parts, 1)) { // nice extension method
      players.add(new MockPlayer(handFactory.createFromLine(hand), iter++));
    }

    Player winner = winnerIndex != -1 ? players.get(winnerIndex) : null;

    return new GameEvaluatorModel(winner, players);
  }

  public static int parseWinner(String winnerText) {
    if (winnerText.toUpperCase().equals("T"))
      return -1;
    else
      return Integer.parseInt(winnerText) - 1;
  }
}
