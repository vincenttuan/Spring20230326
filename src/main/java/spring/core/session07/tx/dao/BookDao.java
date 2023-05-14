package spring.core.session07.tx.dao;

import spring.core.session07.tx.exception.InsufficientAmount;
import spring.core.session07.tx.exception.InsufficientStock;

public interface BookDao {
	// 一般 CRUD ... 略
	// 交易服務
	Integer getBookPrice(Integer bookId); // 取得書本價格
	Integer getBookStock(Integer bookId); // 取得書本庫存量
	Integer getWalletBalance(String username); // 取得客戶目前餘額(balance)
	
	Integer updateBookStock(Integer bookId) throws InsufficientStock; // 更新書本庫存(目前庫存量 - 1)
	Integer updateWallet(String username, Integer bookPrice) throws InsufficientAmount; // 客戶目前餘額(balance) - 書本價格(bookPrice)
}
