package pokerapp.view.events;

import com.google.common.eventbus.EventBus;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * We pass eventbus events in the spring xml allowing spring to register event bus subscriptions
 * 
 * @author Steve
 * @version 1
 */
@AllArgsConstructor
public class SpringGuavaAdapter implements BeanPostProcessor {
  private final EventBus eventBus;

  @Override
  public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
    return o;
  }

  @Override
  public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
    eventBus.register(o);
    return o;

    // code adapted from: http://pmeade.blogspot.co.uk/2012/06/using-guava-eventbus-with-spring.html
    /*
    for (Method method : o.getClass().getMethods()) {
      for (Annotation annotation : method.getAnnotations()) {
        // if it contains the Subscribe annotation
        if (annotation.annotationType().equals(Subscribe.class)) {
          // register it with the event bus
          eventBus.register(o);
          return o;
        }
      }
    }*/
  }
}
