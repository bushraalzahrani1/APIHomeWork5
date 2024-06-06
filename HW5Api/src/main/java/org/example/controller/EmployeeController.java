package org.example.controller;

import jakarta.ws.rs.*;
import org.example.dao.EmployeeDAO;
import org.example.models.Employee;

import java.util.ArrayList;

    @Path("/employees")

    public class EmployeeController {

        EmployeeDAO dao = new EmployeeDAO();

        @GET
        public ArrayList<Employee> SELECT_ALL_EMPLOYEES() {

            try {
                return dao.SELECT_ALL_EMPLOYEES();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @GET
        @Path("{employee_id}")
        public Employee SELECT_ONE_EMPLOYEE(@PathParam("employee_id") int employee_id) {

            try {
                return dao.selectEmployee(employee_id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @DELETE
        @Path("{employee_id}")
        public void DELETE_JOB(@PathParam("employee_id") int employee_id) {

            try {
                dao.DELETE_EMPLOYEE(employee_id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        @POST
        public void INSERT_JOB(Employee Employees) {

            try {
                dao.INSERT_EMPLOYEE(Employees);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @PUT
        @Path("{employee_id}")
        public void UPDATE_JOB(@PathParam("employee_id") int employee_id, Employee employees) {

            try {
                employees.setJob_id(employee_id);
                dao.UPDATE_EMPLOYEE(employees);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


