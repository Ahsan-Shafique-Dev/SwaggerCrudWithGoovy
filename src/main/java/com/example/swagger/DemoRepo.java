/*
package com.example.swagger;

import com.example.swagger_codgen.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Repository
public class DemoRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    DemoRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    RowMapper<Employee> employeeRowMapper = new RowMapper<Employee>() {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setFirstName(rs.getString("firstName"));
            employee.setLastName(rs.getString("lastName"));
            employee.setDepartment(rs.getString("department"));
            return employee;
        }
    };

    String getAllRecordQuery = "SELECT * FROM employee";
    String addRecordQuery = "INSERT INTO employee (firstName, lastName, department) VALUES (?,?,?)";
    String updateRecordQuery = "UPDATE employee SET firstName = ?, lastName = ?, department = ? WHERE id = ?";
    String deleteRecordQuery = "DELETE FROM employee WHERE id = ?";
    String deleteAllRecordQuery = "DELETE FROM employee";

    public List<Employee> getAllDetail() {
        return jdbcTemplate.query(getAllRecordQuery, employeeRowMapper);
    }

    public int addEmployeeDetail(Employee employee) {
        return jdbcTemplate.update(addRecordQuery, employee.getFirstName(), employee.getLastName(), employee.getDepartment());
    }

    public int updateEmployeeDetail(int id, Employee employee) {
        return jdbcTemplate.update(updateRecordQuery, employee.getFirstName(), employee.getLastName(), employee.getDepartment(), id);
    }

    public int deleteEmployeeDetail(int id) {
        return jdbcTemplate.update(deleteRecordQuery, id);
    }

    public int deleteAllEmployee() {
        return jdbcTemplate.update(deleteAllRecordQuery);
    }
}
*/
