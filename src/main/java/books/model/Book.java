package books.model;

public class Book {
	private long id;
	private Title title;
	private Integer price;
	
	public Book(long id, String koreanTitle, String englishTitle, Integer price) {
		this.id = id;
		this.title = new Title(koreanTitle, englishTitle);
		this.price = price;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	public String toString() {
		return  "Book: {\n" +
				  "ID: " + id + "\n" +
				  "Title: {" + title + "}\n" + 
				  "Price: " + price + "\n" +
				"}";
	}
}
