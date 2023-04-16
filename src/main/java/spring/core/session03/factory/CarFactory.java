package spring.core.session03.factory;

import java.util.Random;

import org.springframework.beans.factory.FactoryBean;

import spring.core.session03.bean.Car;

public class CarFactory implements FactoryBean<Car> {

	@Override
	public Car getObject() throws Exception {
		Random random = new Random();
		int price = random.nextInt(300_0000);
		return new Car("BMW", price);
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}
	
	// 用來設定 Car 實體是否是 single ton
	@Override
	public boolean isSingleton() {
		return true;
	}

}
