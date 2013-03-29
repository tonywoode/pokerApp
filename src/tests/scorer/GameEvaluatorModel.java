package tests.scorer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pokerapp.Hand;
import pokerapp.HandFactory;

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
  @Getter private final Hand winner;
  @Getter private final List<Hand> hands;

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
    if (p != -1) {
      line = line.substring(0, p - 1);
    }

    line = line.trim();

    String[] parts = line.split("\\|");

    int winnerIndex = parseWinner(parts[0]); // -1 for tie

    HandFactory handFactory = new HandFactory();

    List<Hand> hands = new ArrayList<>();
    for (String hand : new IteratorExtensions<String>().from(parts, 1)) { // nice extension method
      hands.add(handFactory.createFromLine(hand));
    }

    Hand winner = winnerIndex != -1 ? hands.get(winnerIndex) : null;

    return new GameEvaluatorModel(winner, hands);
  }

  public static int parseWinner(String winnerText) {
    if (winnerText.toUpperCase().equals("T"))
      return -1;
    else
      return Integer.parseInt(winnerText) - 1;
  }
}
