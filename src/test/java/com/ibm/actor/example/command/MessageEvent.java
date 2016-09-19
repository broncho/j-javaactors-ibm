package com.ibm.actor.example.command;

import java.util.EventObject;

import com.ibm.actor.Message;

/**
 * Author: ZhangXiao
 * Created: 2016/9/19
 */
public class MessageEvent extends EventObject {

    private Message message;

    private boolean consumed = false;

    public MessageEvent(Object source, Message message) {
        super(source);
        this.message = message;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }


    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}