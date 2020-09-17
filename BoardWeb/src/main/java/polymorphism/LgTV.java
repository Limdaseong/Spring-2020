package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv") // id값
public class LgTV implements Tv{
	@Autowired // bean이 있으면 자동으로 연결해줌 but 2개 이상이면 오류 터짐
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("LgTV 객체화!!");
	}
	
	public LgTV(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV --- 전원 켠다.");
	}
	
	@Override
	public void powerOff() {
		System.out.println("LgTV --- 전원 끈다.");
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
