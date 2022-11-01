package org.top.jsonapiservicesolvation.messages;

import java.util.Date;

// Класс простого сообщения
public class Messages implements IMessage {
    public String message;  // строка сообщения
    public Date time;       // время

    public Messages(String message) {
        this.message = message;
        this.time = new Date();
    }

    @Override
    public String toString() {
        return time + ": " + message;
    }
}

