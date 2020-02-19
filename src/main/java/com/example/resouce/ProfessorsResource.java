package com.example.resouce;

import com.example.datamodel.Professor;
import com.example.service.ProfessorsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

// .. /webapi/professors
@Path("professors")
public class ProfessorsResource {

    ProfessorsService profService = new ProfessorsService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> getProfessors() {
        return profService.getAllProfessors();
    }

//    @GET
//    @Path("/{department}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Professor> getProfessorsByDeparment(
//            @QueryParam("department") String department			) {
//
//        if (department == null) {
//            return profService.getAllProfessors();
//        }
//        return profService.getProfessorsByDepartment(department);
//
//    }

    // ... webapi/professor/1
    @GET
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor getProfessor(@PathParam("professorId") String profId) {
        System.out.println("Professor Resource: Looking for: " + profId);
        return profService.getProfessor(profId);
    }

    @DELETE
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor deleteProfessor(@PathParam("professorId") long profId) {
        return profService.deleteProfessor(profId);
    }

//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Professor addProfessor(Professor prof) {
//        prof.setProfessorId(prof.getFirstName()+prof.getLastName());
//        prof.setJoiningDate(new Date().toString());
//        //prof.setId(prof.getProfessorId());
//        return profService.addProfessor(prof);
//    }

    @PUT
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Professor updateProfessor(@PathParam("professorId") long profId,
                                     Professor prof) {
        return profService.updateProfessorInformation(String.valueOf(profId), prof);
    }

    public void addProfessor(String firstName, String lastName, String department, Date joiningDate) {
        profService.addProfessor(firstName, lastName, department, joiningDate);
    }
}
