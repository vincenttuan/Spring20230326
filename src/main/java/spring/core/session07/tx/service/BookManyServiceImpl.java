package spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.core.session07.tx.exception.InsufficientAmount;
import spring.core.session07.tx.exception.InsufficientStock;

@Service
public class BookManyServiceImpl implements BookManyService {
	
	@Autowired
	private BookOneService bookOneService;
	
	@Transactional(
			rollbackFor = {InsufficientStock.class, InsufficientAmount.class}
	)
	@Override
	public void buyMany(String username, Integer... bookIds) throws InsufficientStock, InsufficientAmount {
		// 利用 for-loop 買多本書
		for(Integer bookId : bookIds) {
			// 一次買一本
			bookOneService.buyOne(username, bookId);
		}
	}

}
