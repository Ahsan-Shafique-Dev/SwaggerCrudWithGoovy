package com.example.swagger;
import com.example.swagger_codgen.api.DeleteEmployeeApi;
import com.example.swagger_codgen.api.EmployeeDetailsApi;
import com.example.swagger_codgen.api.UpdateEmployeedetailsApi;
import com.example.swagger_codgen.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class DemoController implements  DeleteEmployeeApi, EmployeeDetailsApi, UpdateEmployeedetailsApi {
    DemoService demoService;

    @Autowired
    DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeRecord() {
        return ResponseEntity.status(200).body(demoService.getAllDetail());
    }

    @Override
    public ResponseEntity<Integer> addEmployeeRecord(@Valid Employee employee) {
        return ResponseEntity.status(200).body(demoService.addEmployeeDetail(employee));
    }

    @Override
    public ResponseEntity<Integer> updateEmployeeRecords(@Valid Employee employee, @NotNull @Valid Integer id) {
        return ResponseEntity.status(200).body(demoService.updateEmployeeDetail(id, employee));
    }

    @Override
    public ResponseEntity<Integer> deleteEmployeeRecordByID(@NotNull @Valid Integer id) {
        return ResponseEntity.status(200).body(demoService.deleteEmployeeDetail(id));
    }

//    @Override
//    public ResponseEntity<Integer> deleteAllEmployees(@Valid Employee body) {
//        return ResponseEntity.status(200).body(demoService.deleteAllEmployee());
//    }
}
