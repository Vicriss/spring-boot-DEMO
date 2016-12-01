package org.wcb.entity;

public class User {
  private int id;
  private String username;
  private String password;
  private int isAdmin;

  public User() {}

  public User(int id, String username, String password, int isadmin) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.isAdmin = isadmin;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getIsadmin() {
    return isAdmin;
  }

  public void setIsadmin(int isAdmin) {
    this.isAdmin = isAdmin;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", isadmin=" + isAdmin +
            '}';
  }
}
