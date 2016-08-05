package net.bac.sample.repository.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.bac.sample.repository.model.entity.Employee;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author gdiazs
 */
public class EmployeeMapper implements RowMapper<Employee> {

  @Override
  public Employee mapRow(ResultSet rs, int row) throws SQLException {
    
    Employee employee = new Employee();
    employee.setCreatedAt(rs.getDate("created_at"));
    employee.setId(rs.getInt("id"));
    employee.setName(rs.getString("name"));
    employee.setPosition(rs.getString("position"));
    employee.setUpdatedAt(rs.getDate("updated_at"));
    
    return employee;
  }

}
