package pokerapp.view.events;

import com.google.common.eventbus.EventBus;

/**
 * Guava event handling for message passing events
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
