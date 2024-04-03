package io.arrogantprogrammer.devnexus2024.openai.infrastructure;

import io.arrogantprogrammer.devnexus2024.openai.domain.PoemTopic;
import io.arrogantprogrammer.devnexus2024.openai.domain.PoemWith;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class OpenaiService {
    static final Logger LOGGER = LoggerFactory.getLogger(OpenaiService.class);

    @Inject
    OpenaiClient openaiClient;

    public String whoIsCharacter(final String characterName) {
        String whoIs = openaiClient.whoIsCharacter(characterName);
        LOGGER.info("whoIsCharacter: {}", whoIs);
        return whoIs;
    }

    public String poemAbout(PoemTopic poemTopic) {
        String poem = openaiClient.writeAPoem(poemTopic.characterName(), poemTopic.poet());
        LOGGER.info("poem: {}", poem);
        return poem;
    }

    public String poemWith(PoemWith poemWith) {
        String poem = openaiClient.addThisToThePoem(poemWith.poem(), poemWith.withTopic());
        LOGGER.info("poem: {}", poem);
        return poem;
    }
}
