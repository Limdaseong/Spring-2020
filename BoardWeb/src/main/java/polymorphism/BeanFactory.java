package polymorphism;

public class BeanFactory {
	//Factory라 적혀있는 클래스는 객체 만드는거
	
	public Object getBean(String beanName) {
		switch(beanName) {
		case "samsung":
			return new SamsungTV();
		case "lg":
			return new LgTV();
		}
		return null;
	}
}
