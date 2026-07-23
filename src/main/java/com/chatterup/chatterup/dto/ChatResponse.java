package com.chatterup.chatterup.dto;

import com.chatterup.chatterup.model.Message;

public record ChatResponse(int id, String name, Message message) {
}
