package io.arrogantprogrammer.devnexus2024.openai.infrastructure;

import dev.langchain4j.agent.tool.P;
import io.arrogantprogrammer.devnexus2024.openai.domain.PoemTopic;
import io.arrogantprogrammer.devnexus2024.openai.domain.PoemWith;
import io.arrogantprogrammer.devnexus2024.openai.domain.WhoIsRequest;
import io.arrogantprogrammer.devnexus2024.openai.domain.WhoIsResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/openai")
public class OpenaiResource {

    static final Logger LOGGER = LoggerFactory.getLogger(OpenaiResource.class);

    @Inject
    OpenaiService openaiService;

    @GET
    public String whoIs(@QueryParam("characterName") final String characterName) {
        String whoIs = openaiService.whoIsCharacter(characterName);
        return whoIs;
    }

//    @GET
//    @Path("/poem")
//    public String poem(PoemTopic poemTopic){
//        String poem = openaiService.poemAbout(poemTopic);
//        LOGGER.debug("returning: {}", poem);
//        return poem;
//    }
//
//    @GET
//    @Path("poemWith")
//    public String poemWith(PoemWith poemWith){
//        String poem = openaiService.poemWith(poemWith);
//        LOGGER.debug("returning: {}", poem);
//        return poem;
//    }
}
