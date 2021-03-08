package com.marwa.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("perfectNumber")
public class PerfectNumberController {
  private PerfectNumberService perfectNumberService = new PerfectNumberService();
  private ObjectMapper objectMapper = new ObjectMapper();

  @GET
  @Path("{number}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPerfectNumber(@PathParam("number") int number) throws JsonProcessingException {
    if (number > 10000) {
      return Response
          .status(Response.Status.BAD_REQUEST)
          .entity("Number should be less than or equal 10000")
          .build();
    }
    String resp = objectMapper.writeValueAsString(perfectNumberService.getPerfectNumberResponse(number));

    return Response
        .status(Response.Status.OK)
        .entity(resp)
        .build();
  }

  @GET()
  @Path("/range")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPerfectNumberRange(@QueryParam("start") int start, @QueryParam("end") int end)
      throws JsonProcessingException {
    this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    String resp = objectMapper.writeValueAsString(perfectNumberService.getPerfectNumberResponseInRange(start, end));
    if (start == 0 || end == 0) {
      return Response
          .status(Response.Status.BAD_REQUEST)
          .entity("Please Provide start and end")
          .build();
    }
    return Response
        .status(Response.Status.OK)
        .entity(resp)
        .build();
  }


}