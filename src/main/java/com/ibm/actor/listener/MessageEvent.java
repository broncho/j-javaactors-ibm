package com.ibm.actor.listener;

import java.util.EventObject;

import com.ibm.actor.message.Message;

/**
 * Sent when a message is received.
 *
 * @author BFEIGENB
 */
public class MessageEvent extends EventObject {

    /**
     * Possible message events.
     *
     * @author BFEIGENB
     */
    public enum MessageStatus {
        SENT, DELIVERED, COMPLETED, FAILED
    }

    protected MessageStatus status;

    protected Message message;

    public MessageStatus getStatus() {
        return status;
    }

    public MessageEvent(Object source, Message m, MessageStatus status) {
        super(source);
        this.message = m;
        this.status = status;
    }
}
