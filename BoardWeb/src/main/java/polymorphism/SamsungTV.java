package polymorphism;

public class SamsungTV implements Tv{ 
	private Speaker speaker;
	
	// vo가 아닌 이상 객체 생성 x
	
	// is, has 관계  extends는 포함될 때(is)
	
	public SamsungTV() {
		System.out.println("SamsungTV 객체화!!!!");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("speaker 생성자");
		this.speaker = speaker; // 스피커 생성자
		// 컨테이너가 객체 생성을 한다
	}
	
	public SamsungTV(int a,Speaker speaker) {
		System.out.println("a : " + a);
		System.out.println("speaker, a 생성자");
		this.speaker = speaker; 
	}
	
	public SamsungTV(Speaker speaker, int a) {
		System.out.println("a : " + a);
		System.out.println("speaker, a 생성자");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, String a) {
		System.out.println("a : " + a);
		System.out.println("speaker, String a 생성자");
		this.speaker = speaker;
	}
	
	public SamsungTV(int a) {
		System.out.println("a  생성자");
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV --- 전원 켠다.");
	}
	
	@Override
	public void powerOff() {
		System.out.println("SamsungTV --- 전원 끈다.");
	}
	
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
}
