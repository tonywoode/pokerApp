package pokerapp;

/**
 * @author Steve
 * @author Ari
 * @author Sam
 * @version 1.0
 */
public class InteractivePlayer extends Player {

  public InteractivePlayer(String name) {
    setPlayerName(name);
  }

  public InteractivePlayer() {
    this("");
  }

  @Override
  public void visit(PlayerVisitor visitor) {
    visitor.accept(this);
  }
}
