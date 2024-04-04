package io.arrogantprogrammer.devnexus2024.openai.infrastructure;

import io.arrogantprogrammer.devnexus2024.openai.domain.*;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/openai")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OpenaiResource {

    static final Logger LOGGER = LoggerFactory.getLogger(OpenaiResource.class);

    @Inject
    OpenaiService openaiService;

    @POST
    @Path("/whois")
    public Response whoIs(WhoIsRequest whoIsRequest) {
        String whoIs = openaiService.whoIsCharacter(whoIsRequest.characterName());
        WhoIsResponse whoIsResponse = new WhoIsResponse(whoIsRequest.characterName(), whoIs);
        return Response.ok().entity(whoIsResponse).build();
    }

    @POST
    @Path("/poem")
    public Response poem(PoemRequest poemRequest) {
        String poem = openaiService.poemAbout(poemRequest.characterName(), poemRequest.poet());
        PoemResponse poemResponse = new PoemResponse(poemRequest.characterName(), poemRequest.poet(), poem);
        LOGGER.debug("returning: {}", poemResponse);
        return Response.ok().entity(poemResponse).build();
    }

    @POST
    @Path("/addtopoem")
    public Response poemWith(AddToPoemRequest addToPoemRequest) {
        String poemWith = openaiService.poemWith(addToPoemRequest.poem(), addToPoemRequest.withTopic());
        AddToPoemResponse addToPoemResponse = new AddToPoemResponse(addToPoemRequest.poem(), addToPoemRequest.withTopic(), poemWith);
        LOGGER.debug("returning: {}", addToPoemResponse);
        return Response.ok().entity(addToPoemResponse).build();
    }
}
