package books.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shelf")
public class Book {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "title", nullable = false)
	private String title;
	@Column(name = "price", nullable = false)
	private int price;
	
	protected Book() {
		/* Do nothing */
	}
	
	public Book(long id, String title, int price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String toString() {
		return  "Book: {\n" +
				  "ID: " + id + "\n" +
				  "Title: " + title + "\n" + 
				  "Price: " + price + "\n" +
				"}";
	}
}
