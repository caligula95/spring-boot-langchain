package com.langchainexample.service;

import com.langchainexample.controller.dto.ChatRequest;
import com.langchainexample.model.BookModel;

public interface GenAIService {

    String getResponse(ChatRequest request);

    BookModel getBookModelFromText(String question);
}
