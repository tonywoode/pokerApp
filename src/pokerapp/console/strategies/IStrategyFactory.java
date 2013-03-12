package pokerapp.console.strategies;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 12/03/13
 * Time: 00:07
 * To change this template use File | Settings | File Templates.
 * This is an implementation of the abstract factory
 */



public interface IStrategyFactory {
    IStrategy createStrategy(String handType);
}
