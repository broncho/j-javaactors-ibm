package com.ibm.actor.example.command;

import java.util.LinkedList;
import java.util.List;

import com.ibm.actor.AbstractActor;
import com.ibm.actor.message.Message;

/**
 * Author: ZhangXiao
 * Created: 2016/9/19
 */
public class DelegatingActor extends AbstractActor {

    private List<MessageListener> listeners = new LinkedList<>();

    public void addMessageListener(MessageListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void removeMessageListener(MessageListener listener) {
        listeners.remove(listener);
    }

    @Override
    protected void loopBody(Message m) {
        fireMessageListeners(new MessageEvent(this, m));
    }

    private void fireMessageListeners(MessageEvent event) {
        for (MessageListener listener : listeners) {
            if (event.isConsumed()) {
                break;
            } else {
                listener.onMessage(event);
            }
        }
    }
}
