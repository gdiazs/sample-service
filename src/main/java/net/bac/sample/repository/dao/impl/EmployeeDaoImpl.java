package net.bac.sample.repository.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.bac.sample.repository.dao.EmployeeDao;
import net.bac.sample.repository.model.entity.Employee;
import net.bac.sample.repository.model.mapper.EmployeeMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

  private static final String SQL_INSERT = "insert into employees (id, name, position, created_at, updated_at)values (?, ?, ?, ?, ?)";
  private static final String SQL_DELETE_BY_ID = "delete from employees where employees.id = ?";
  private static final String SQL_FIND_BY_ID = "select id, name, position, created_at, updated_at  from employees where employees.id = ?";
  private static final String SQL_UPDATE_BY_ID = "update employees set id = ?, name = ?, position = ?, created_at = ?, updated_at = ? where employees.id = ?";

  private DataSource dataSource;

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public EmployeeDaoImpl(DataSource ds) {
    dataSource = ds;
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public int insert(Employee employee) {
    int rowCount = jdbcTemplate.update(SQL_INSERT, employee.getId(),
        employee.getName(), employee.getPosition(), employee.getCreatedAt(),
        employee.getUpdatedAt());
    return rowCount;
  }

  @Override
  public boolean delete(Employee t) {
    int rowCount = jdbcTemplate.update(SQL_DELETE_BY_ID, t.getId());
    return rowCount > 0;
  }

  @Override
  public Employee find(Employee employee) {
    Employee employeeFound = jdbcTemplate.queryForObject(SQL_FIND_BY_ID,
        new Object[] { employee.getId() }, new EmployeeMapper());
    return employeeFound;
  }

  @Override
  public boolean update(Employee old, Employee newOne) {
    int rowCount = jdbcTemplate.update(SQL_UPDATE_BY_ID, newOne.getId(),
        newOne.getName(), newOne.getPosition(), newOne.getCreatedAt(),
        newOne.getUpdatedAt(), old.getId());
    return rowCount > 0;
  }

}
