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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    if (id != book.id) return false;
    if (Double.compare(book.price, price) != 0) return false;
    if (sales != book.sales) return false;
    if (balance != book.balance) return false;
    if (name != null ? !name.equals(book.name) : book.name != null) return false;
    return author != null ? author.equals(book.author) : book.author == null;

  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (author != null ? author.hashCode() : 0);
    temp = Double.doubleToLongBits(price);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + sales;
    result = 31 * result + balance;
    return result;
  }
}
