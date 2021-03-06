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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (id != user.id) return false;
    if (isAdmin != user.isAdmin) return false;
    if (username != null ? !username.equals(user.username) : user.username != null) return false;
    return password != null ? password.equals(user.password) : user.password == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (username != null ? username.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + isAdmin;
    return result;
  }
}
