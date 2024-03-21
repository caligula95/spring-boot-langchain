package com.langchainexample.service;

import com.langchainexample.model.BookModel;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

import java.util.List;

public interface Assistant {

    @SystemMessage(
            """
                    You are a helpful assistant. Try to respond in a fair and warm manner.
                    If you don't know answer, just tell it.
                    """
    )
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    @SystemMessage("Extract information about a book from {{text}}")
    @UserMessage("And genre should be from this list {{genresList}}")
    BookModel extractBookFromText(@V("text") String text, @V("genresList") List<String> genres);
}
