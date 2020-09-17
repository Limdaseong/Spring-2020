package polymorphism;

public class TvTest {
	public static void main(String[] args) {
		BeanFactory bean = new BeanFactory();
		// 소스를 수정해야하는 것은 좋은 코드가 아니다
		
		Tv tv = (Tv)bean.getBean(args[0]);
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
