package net.bac.sample.repository.model.entity;

import java.util.Date;

/**
 * @author gdiazs
 */
public class Employee {

  private Integer id;
  
  private String name;
  
  private String position;
  
  private Date createdAt;
  
  private Date updatedAt;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", position=" + position
        + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
  }
  
  
  
}
