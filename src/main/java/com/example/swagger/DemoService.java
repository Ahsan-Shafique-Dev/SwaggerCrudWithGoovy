package com.example.swagger;

import com.example.swagger_codgen.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class DemoService {
//        DemoRepo groovyRepo;
    GroovyRepo groovyRepo;
//    Employee employee;

    @Autowired
    public DemoService(GroovyRepo groovyRepo) {
        this.groovyRepo = groovyRepo;
    }

    public List<Employee> getAllDetail() {
        return groovyRepo.getAllDetail();
    }

    public int addEmployeeDetail(Employee employee) {
        return groovyRepo.addEmployeeDetail(employee);
    }

    public int updateEmployeeDetail(int id, Employee employee) {
        return groovyRepo.updateEmployeeDetail(id, employee);
    }

    public int deleteEmployeeDetail(int id) {
        return groovyRepo.deleteEmployeeDetail(id);
    }

    public int deleteAllEmployee() {
        return groovyRepo.deleteAllEmployee();
    }
}
