package spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookManyServiceImpl implements BookManyService {
	
	@Autowired
	private BookOneService bookOneService;
	
	@Transactional
	@Override
	public void buyMany(String username, Integer... bookIds) {
		// 利用 for-loop 買多本書
		for(Integer bookId : bookIds) {
			// 一次買一本
			bookOneService.buyOne(username, bookId);
		}
	}

}
