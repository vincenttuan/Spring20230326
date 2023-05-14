package spring.core.session07.tx.exception;

// 金額不足
public class InsufficientAmount extends Exception {
	public InsufficientAmount(String message) {
		super(message);
	}
}
