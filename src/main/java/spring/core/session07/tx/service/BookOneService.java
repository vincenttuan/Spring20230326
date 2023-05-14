package spring.core.session07.tx.service;

import spring.core.session07.tx.exception.InsufficientAmount;
import spring.core.session07.tx.exception.InsufficientStock;

// 買單本書
public interface BookOneService {
	void buyOne(String username, Integer bookId) throws InsufficientStock, InsufficientAmount;
}
