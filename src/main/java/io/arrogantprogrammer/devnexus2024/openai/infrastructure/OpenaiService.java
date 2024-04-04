package io.arrogantprogrammer.devnexus2024.openai.infrastructure;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
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

    public String poemAbout(final String poemTopic, final String poet) {
        LOGGER.debug("Retrieving a poem about {} in the style of {}", poemTopic, poet);
        return openaiClient.writeAPoem(poemTopic, poet);
    }

    public String poemWith(final String poem, final String withTopic) {
        LOGGER.debug("Retrieving a poem with {}", withTopic);
        String poemWith = openaiClient.addThisToThePoem(withTopic, poem);
        return poemWith;
    }
}
