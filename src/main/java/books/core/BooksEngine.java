package books.core;

import java.util.*;

import books.model.*;
import books.repository.BooksRepository;

public class BooksEngine {
	public static String getBook(BooksRepository repo, long id) {
		StringBuffer sb = new StringBuffer();
		try {
			if (id < 0) {
				List<Book> bookList = repo.findAll();
				if (bookList.size() > 0) {
					for (Book book : bookList) {
						System.out.println(book.toString());
						sb.append(book.toString());
					}
				} else {
					sb.append("Empty Book List");
				}
			} else {
				Book book = repo.getOne(id);
				sb.append(book.toString());
			}
		} catch (Exception ex) {
			String errorMessage = ex.getMessage();
			System.out.println(errorMessage);
			sb.append(errorMessage);
		}
		
		return sb.toString();
	}
	
	public static String saveBook(BooksRepository repo, String title, int price) {
		Book newBook = new Book(0, title, price);
		
		repo.save(newBook);
		
		return newBook.toString();
	}
	
	public static String updateBook(BooksRepository repo, long id, String title, Integer price) {
		Book updatedBook = repo.getOne(id);
		
		if (title != null) updatedBook.setTitle(title);
		if (price != null) updatedBook.setPrice(price);
		
		repo.save(updatedBook);
		
		return updatedBook.toString(); 
	}
	
	public static String deleteBook(BooksRepository repo, long id) {
		Book deletedBook = repo.getOne(id);
		
		repo.delete(id);
		
		return deletedBook.toString();
	}
}
