package spring.core.session07.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
	
	// 更新書本庫存(目前庫存量 - 1)
	@Override
	public Integer updateBookStock(Integer bookId) {
		// 1. 檢查庫存
		Integer bookStock = getBookStock(bookId);
		if(bookStock <= 0) { // 書本庫存量不足
			throw new RuntimeException("書本庫存量不足: book id = " + bookId + ", book stock = " + bookStock);
		}
		// 2. 修改庫存/更新書本庫存(目前庫存量 - 1)
		String sql = "update stock set book_amount = book_amount - 1 where book_id = ?";
		int rowcount = jdbcTemplate.update(sql, bookId);
		return null;
	}

	@Override
	public Integer updateWallet(String username, Integer price) {
		// TODO Auto-generated method stub
		return null;
	}

}
