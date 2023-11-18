package kafka.publicInterface;

import kafka.model.Message;

/**
 * 
 * @created 31/05/2021
 */
public interface ISubscriber {
    String getId();

    void consume(Message message);
}
