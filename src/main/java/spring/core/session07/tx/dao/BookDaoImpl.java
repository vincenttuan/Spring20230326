package spring.core.session07.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.core.session07.tx.exception.InsufficientAmount;
import spring.core.session07.tx.exception.InsufficientStock;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(
			propagation = Propagation.REQUIRES_NEW,
			readOnly = true
	)
	@Override
	public Integer getBookPrice(Integer bookId) {
		// 取得書本價格
		String sql = "select book_price from book where book_id = ?";
		Object[] args = {bookId};
		Integer bookPrice = jdbcTemplate.queryForObject(sql, args, Integer.class);
		//Integer bookPrice = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
		return bookPrice;
	}

	@Override
	public Integer getBookStock(Integer bookId) {
		// 取得書本庫存
		String sql = "select book_amount from stock where book_id = ?";
		Object[] args = {bookId};
		Integer bookStock = jdbcTemplate.queryForObject(sql, args, Integer.class);
		return bookStock;
	}
	
	@Override
	public Integer getWalletBalance(String username) {
		// 取得客戶目前餘額(balance)
		String sql = "select balance from wallet where username = ?";
		Object[] args = {username};
		Integer balance = jdbcTemplate.queryForObject(sql, args, Integer.class);
		return balance;
	}
	
	// 更新書本庫存(目前庫存量 - 1)
	@Override
	public Integer updateBookStock(Integer bookId) throws InsufficientStock {
		// 1. 檢查庫存
		Integer bookStock = getBookStock(bookId);
		if(bookStock <= 0) { // 書本庫存量不足
			throw new InsufficientStock("書本庫存量不足: book id = " + bookId + ", book stock = " + bookStock);
		}
		// 2. 修改庫存/更新書本庫存(目前庫存量 - 1)
		String sql = "update stock set book_amount = book_amount - 1 where book_id = ?";
		int rowcount = jdbcTemplate.update(sql, bookId);
		return rowcount;
	}
	
	// 客戶目前餘額更新: 客戶目前餘額(balance) - 書本價格(bookPrice)
	@Override
	public Integer updateWallet(String username, Integer bookPrice) throws InsufficientAmount {
		// 1. 檢查客戶餘額
		Integer balance = getWalletBalance(username);
		if(balance < bookPrice) { // 餘額不足（不足以購買此書）
			throw new InsufficientAmount("餘額不足: balance = $" + balance + ", bookPrice = $" + bookPrice);
		}
		// 2. 修改客戶餘額: 客戶目前餘額(balance) - 書本價格(bookPrice)
		String sql = "update wallet set balance = balance - ? where username = ?";
		int rowcount = jdbcTemplate.update(sql, bookPrice, username);
		return rowcount;
	}

}
