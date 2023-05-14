package spring.core.session07.tx.exception;

// 庫存不足
public class InsufficientStock extends Exception {
	public InsufficientStock(String message) {
		super(message);
	}
}
