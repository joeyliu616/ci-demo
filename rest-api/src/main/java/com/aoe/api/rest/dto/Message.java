package com.aoe.api.rest.dto;

import java.util.UUID;

/**
 * Created by joey on 16-8-4.
 */
public class Message {
    private String id = UUID.randomUUID().toString();
    private String content;

    Message() {
    }

    public Message(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
