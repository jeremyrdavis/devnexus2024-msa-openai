package io.arrogantprogrammer.devnexus2024.openai.infrastructure;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface OpenaiClient {

    @UserMessage("""
                Who is {character}?
            """)
    String whoIsCharacter(final String character);

    @UserMessage("""
                Write a poem about {topic} in the style of {poet}.
            """)
    String writeAPoem(String topic, String poet);

    @UserMessage("""
                Add {topic} the the following poem: {poem}.
            """)
    String addThisToThePoem(String topic, String poem);
}
