package net.bac.sample.repository.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import javax.sql.DataSource;

import net.bac.sample.repository.config.AbstractDataBaseConfigTest;
import net.bac.sample.repository.dao.EmployeeDao;
import net.bac.sample.repository.model.entity.Employee;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeDaoImplTest extends AbstractDataBaseConfigTest {

  @Autowired
  private EmployeeDao employeeDao;
  
  @Autowired
  private DataSource dataSource;
  
  @Test
  public void TestDataSource(){
    
    Assert.assertNotNull(dataSource);
  }
  
  @Test
  public void TestEmployeeDao(){
    Assert.assertNotNull(dataSource);
  }


  @Test
  public void testInsert() {
   
    int expected = 1;
    
    Employee newEmployee = new Employee();
    newEmployee.setCreatedAt(new Date());
    newEmployee.setId(500);
    newEmployee.setName("TestName");
    newEmployee.setPosition("Manager");
    newEmployee.setUpdatedAt(new Date());
    
    int actual = employeeDao.insert(newEmployee);
    
    assertTrue(actual >= expected);
  }

  @Test
  public void testDelete() {
   
    
    Employee idEmployee = new Employee();
    idEmployee.setId(1);
    
    boolean actual = employeeDao.delete(idEmployee);
    assertTrue(actual);
  }

  @Test
  public void testFind() {
    Employee idEmployee = new Employee();
    idEmployee.setId(300);
    Employee employeeFound = employeeDao.find(idEmployee);
    assertTrue(employeeFound.getId().equals(idEmployee.getId()));
    System.out.println(employeeFound);
  }

  @Test
  public void testUpdate() {

    Employee oldEmployee = new Employee();
    oldEmployee.setId(500);
    
    Employee newEmployeeData = new Employee();
    newEmployeeData.setCreatedAt(new Date());
    newEmployeeData.setId(500);
    newEmployeeData.setName("TestName");
    newEmployeeData.setPosition("Manager");
    newEmployeeData.setUpdatedAt(new Date());
    
    boolean actual = employeeDao.update(oldEmployee, newEmployeeData);
    
    assertTrue(actual);
    
  }

}
