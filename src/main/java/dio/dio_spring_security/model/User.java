package dio.dio_spring_security.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_user")
  private Integer id;
  @Column(length = 50, nullable = false)
  private String name;
  @Column(length = 20, nullable = false)
  private String username;
  @Column(length = 100, nullable = false)
  private String password;
  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name = "user_id"))
  @Column(name = "role_id")
  private List<String> roles = new ArrayList<>();

  public User() {
    
  }

  public User(String username) {
    this.username = username;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

}
