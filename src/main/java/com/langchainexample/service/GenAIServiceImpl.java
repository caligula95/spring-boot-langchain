package com.langchainexample.service;

import com.langchainexample.controller.dto.ChatRequest;
import com.langchainexample.model.BookModel;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenAIServiceImpl implements GenAIService {

    private final Assistant assistant;

    @Override
    public String getResponse(ChatRequest request) {
        return assistant.chat(request.userId(), request.question());
    }

    @Override
    public BookModel getBookModelFromText(String question) {
        var popularGenres = List.of("Fiction", "Mystery", "Romance", "Science Fiction", "Fantasy", "Thriller", "Historical Fiction", "Young Adult", "Non-Fiction", "Biography");
        return assistant.extractBookFromText(question, popularGenres);
    }

    public String getResponseSimple(ChatRequest request) {
        List<ChatMessage> messages = new ArrayList<>();
        messages.add(UserMessage.userMessage(request.question()));
        var model = OpenAiChatModel.builder()
                .apiKey("demo")
                .modelName(OpenAiChatModelName.GPT_3_5_TURBO)
                .build();
        return model.generate(messages).content().text();
    }
}
