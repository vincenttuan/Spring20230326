package spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.core.session07.tx.dao.BookDao;
import spring.core.session07.tx.exception.InsufficientAmount;
import spring.core.session07.tx.exception.InsufficientStock;

@Service
public class BookOneServiceImpl implements BookOneService {
	
	@Autowired
	private BookDao bookDao;
	
	@Transactional( // tx
			propagation = Propagation.REQUIRED // 預設: 若當前有 tx, 則繼續使用; 若當前沒有 tx 就建立一個 tx
	)
	@Override
	public void buyOne(String username, Integer bookId) throws InsufficientStock, InsufficientAmount {
		// 1. 查詢書本價格
		Integer bookPrice = bookDao.getBookPrice(bookId);
		// 2. 減去 Stock 書本庫存
		bookDao.updateBookStock(bookId);
		// 3. 修改 Wallet 餘額
		bookDao.updateWallet(username, bookPrice);
	}

}
