package spring.core.session07.tx.dao;

public interface BookDao {
	// 一般 CRUD ... 略
	// 交易服務
	Integer getBookPrice(Integer bookId); // 取得書本價格
	Integer getBookStock(Integer bookId); // 取得書本庫存量
	Integer updateBookStock(Integer bookId); // 更新書本庫存(目前庫存量 - 1)
	Integer updateWallet(String username, Integer price); // 客戶目前餘額(balance) - 書本價格(price)
}
