package spring.core.session07.tx.service;

// 買多本書
public interface BookManyService {
	void buyMany(String username, Integer... bookIds);
}
