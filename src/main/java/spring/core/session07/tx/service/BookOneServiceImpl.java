package spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;

import spring.core.session07.tx.dao.BookDao;

public class BookOneServiceImpl implements BookOneService {
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public void buyOne(String username, Integer bookId) {
		// 1. 查詢書本價格
		Integer bookPrice = bookDao.getBookPrice(bookId);
		// 2. 減去 Stock 書本庫存
		bookDao.updateBookStock(bookId);
		// 3. 修改 Wallet 餘額
		bookDao.updateWallet(username, bookPrice);
	}

}
