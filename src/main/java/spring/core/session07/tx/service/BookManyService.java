package spring.core.session07.tx.service;

import spring.core.session07.tx.exception.InsufficientAmount;
import spring.core.session07.tx.exception.InsufficientStock;

// 買多本書
public interface BookManyService {
	void buyMany(String username, Integer... bookIds) throws InsufficientStock, InsufficientAmount;
}
