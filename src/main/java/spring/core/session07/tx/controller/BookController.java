package spring.core.session07.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.core.session07.tx.exception.InsufficientAmount;
import spring.core.session07.tx.exception.InsufficientStock;
import spring.core.session07.tx.service.BookManyService;
import spring.core.session07.tx.service.BookOneService;

@Controller
public class BookController {
	@Autowired
	private BookOneService bookOneService;
	
	@Autowired
	private BookManyService bookManyService;
	
	public void buyOneBook(String username, Integer bookId) {
		try {
			bookOneService.buyOne(username, bookId);
		} catch (InsufficientStock | InsufficientAmount e) {
			System.out.println(e);
		}
		System.out.println("buyOneBook OK");
	}
	
	public void buyManyBooks(String username, Integer... bookIds) {
		try {
			bookManyService.buyMany(username, bookIds);
		} catch (InsufficientStock | InsufficientAmount e) {
			System.out.println(e);
		}
		System.out.println("buyManyBooks OK");
	}
	
}
