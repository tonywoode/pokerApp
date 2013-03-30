package pokerapp;

/**
 * <p>
 *   Enables clients to visit the various Player subclasses.
 * </p>
 * <p>
 *   Implements the visitor pattern.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public interface PlayerVisitor {

  void accept(InteractivePlayer interactivePlayer);
  void accept(ComputerPlayer computerPlayer);

}
