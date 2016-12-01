package org.wcb.entity;

public class Book {
  private int id;
  private String name;
  private String author;
  private double price;
  private int sales;
  private int balance;

  public Book() {}

  public Book(int id, String name, String author, double price, int sales, int balance) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.price = price;
    this.sales = sales;
    this.balance = balance;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getSales() {
    return sales;
  }

  public void setSales(int sales) {
    this.sales = sales;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", author='" + author + '\'' +
            ", price=" + price +
            ", sales=" + sales +
            ", balance=" + balance +
            '}';
  }
}
