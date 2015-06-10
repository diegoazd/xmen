package com.xmen.adn.resource

import com.xmen.adn.pattern.FindMutant
import com.xmen.adn.pattern.MutantHelper
import groovy.json.JsonSlurper

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/mutant")
@Produces(MediaType.APPLICATION_JSON)
class MutantResource {
  private static final MutantHelper mutantHelper = new MutantHelper()
  private static final FindMutant findMutant = new FindMutant()
  @GET
  public Boolean foo() {
    new Boolean(true)
  }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response add(String adnSequence) {
      JsonSlurper jsonSlurper = new JsonSlurper()
      def json
      try{
        json = jsonSlurper.parseText(adnSequence)
      }catch(Exception e) {
        return Response.status(500).
            entity("Hey Magneto, no deberias permitir que Mercurio llene la secuencia de adn, " +
                          "el formato del json no es el adecuado").build()
      }

      if(!mutantHelper.validArraySize(json.adnSequence as String[]))
        return Response.status(500).
                entity("Hey Magneto, no deberias permitir que Mercurio llene la secuencia de adn, " +
                        "el tamano de la matriz es incorrect").build()
      if(findMutant.findMutant(mutantHelper.transformInAdnSequence(json.adnSequence as String[])))
        return Response.ok("Haz encontrado un nuevo mutante", MediaType.APPLICATION_JSON).build()
      else
        return Response.ok("No es un mutante, es un sucio moogle", MediaType.APPLICATION_JSON).build()
    }


}
