package com.example.swagger

import com.example.swagger_codgen.model.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

import java.sql.ResultSet
import java.sql.SQLException

@Repository
class GroovyRepo
{
    JdbcTemplate jdbcTemplate

    @Autowired
    SwaggerRepo(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate
    }

    RowMapper<Employee> employeeRowMapper = new RowMapper<Employee>() {
        @Override
        Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"))
            employee.setFirstName(rs.getString("firstName"))
            employee.setLastName(rs.getString("lastName"))
            employee.setDepartment(rs.getString("department"))
            return employee;
        }
    }

    String getAllRecordQuerry = """SELECT * FROM employee ORDER BY id"""
    String addRecordQuerry = """INSERT INTO employee (firstName, lastName, department) VALUES (?,?,?)"""
    String updateRecordQuerry = """UPDATE employee SET firstName = ?, lastName = ?, department = ? WHERE id = ?"""
    String deleteRecordQuerry = """DELETE FROM employee WHERE id = ?"""
    String deleteAllRecordQuery = """DELETE FROM employee"""

    public List<Employee> getAllDetail()
    {
        return jdbcTemplate.query(getAllRecordQuerry, employeeRowMapper)
    }
    public int addEmployeeDetail(Employee employee)
    {
        return jdbcTemplate.update(addRecordQuerry, employee.getFirstName(), employee.getLastName(), employee.getDepartment())
    }
    public int updateEmployeeDetail(int id, Employee employee)
    {
        return jdbcTemplate.update(updateRecordQuerry, employee.getFirstName(), employee.getLastName(), employee.getDepartment(), id)
    }
    public int deleteEmployeeDetail(int id)
    {
        return jdbcTemplate.update(deleteRecordQuerry, id)
    }
    public int deleteAllEmployee()
    {
        return jdbcTemplate.update(deleteAllRecordQuery)
    }
}
