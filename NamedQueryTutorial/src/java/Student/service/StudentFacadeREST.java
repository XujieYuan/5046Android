/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.service;

import Student.Student;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author yuanxujie
 */
@Stateless
@Path("student.student")
public class StudentFacadeREST extends AbstractFacade<Student> {

    @PersistenceContext(unitName = "NamedQueryTutorialPU")
    private EntityManager em;

    public StudentFacadeREST() {
        super(Student.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Student entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") BigDecimal id, Student entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") BigDecimal id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Student find(@PathParam("id") BigDecimal id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Student> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @GET
    @Path("findByStudname/{studname}")
    @Produces({"application/json"})
    public List<Student> findByStudname(@PathParam("studname") String studname) {
        Query query = em.createNamedQuery("Student.findByStudname");
        query.setParameter("studname", studname);
        return query.getResultList();
    }

    @GET
    @Path("findByStudpostcode/{studpostcode}")
    @Produces({"application/json"})
    public List<Student> findByStudpostcode(@PathParam("studpostcode") String studpostcode) {
        Query query = em.createNamedQuery("Student.findByStudpostcode");
        query.setParameter("studpostcode", studpostcode);
        return query.getResultList();
    }

    @GET
    @Path("findByLikePostcode")
    @Produces({"application/json"})
    public List<Student> findByLikePostCode() {
        Query query = em.createNamedQuery("Student.findByLikePostcode");
        return query.getResultList();
    }

    @GET
    @Path("findByCourse/{courseid}")
    @Produces({"application/json"})
    public List<Student> findByCourse(@PathParam("courseid") Integer courseid) {
        Query query = em.createNamedQuery("Student.findByCourse");
        query.setParameter("courseid", courseid);
        return query.getResultList();
    }

    @GET
    @Path("findByUpperStudname/{studname}")
    @Produces({"application/json"})
    public List<Student> findByUpperStudname(@PathParam("studname") String studname) {
        Query query = em.createNamedQuery("Student.findByUpperStudname");
        query.setParameter("studname", studname);
        return query.getResultList();
    }

    @GET
    @Path("findByLikePostcode2")
    @Produces({"application/json"})
    public List<Student> findByLikePostcode2() {
        TypedQuery<Student> query = em.createQuery(
                "SELECT s FROM Student s WHERE s.studpostcode LIKE '3%'", Student.class);

        return query.getResultList();
    }

    @GET
    @Path("findByCourse2/{courseid}")
    @Produces({"application/json"})
    public List<Student> findByCourse2(@PathParam("courseid") Integer courseid) {
        TypedQuery<Student> q = em.createQuery(
                "SELECT s FROM Student s WHERE s.courseid.courseid = :courseid", Student.class);
        q.setParameter("courseid", courseid);
        return q.getResultList();
    }

    @Path("findByNameANDCode/{studname}/{studpostcode}")
    @Produces({"application/json"})
    public List<Student> findByNameANDCode(@PathParam("studname") String studname, @PathParam("studpostcode") String studpostcode) {
        Query query = em.createNamedQuery("Student.findByNameANDCode");
        query.setParameter("studname", studname);
        query.setParameter("studpostcode", studpostcode);
        return query.getResultList();
    }

    @GET
    @Path("findByCourseName/{coursename}")
    @Produces({"application/json"})
    public List<Student> findByCourseName(@PathParam("coursename") String coursename) {
        TypedQuery<Student> q = em.createQuery(
                "SELECT s FROM Student s WHERE s.courseid.coursename = :coursename", Student.class);
        q.setParameter("coursename", coursename);
        return q.getResultList();
    }
    
}
