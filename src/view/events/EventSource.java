package view.events;

import com.google.common.eventbus.EventBus;

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
public class EventSource {
  private final EventBus eventBus;

  public EventSource(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  public void fire(Object event) {
    eventBus.post(event);
  }

}
