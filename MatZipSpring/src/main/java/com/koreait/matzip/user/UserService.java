package com.koreait.matzip.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.matzip.Const;
import com.koreait.matzip.SecurityUtils;
import com.koreait.matzip.user.model.UserDMI;
import com.koreait.matzip.user.model.UserPARAM;
import com.koreait.matzip.user.model.UserVO;

@Service
public class UserService {
	@Autowired
	private UserMapper mapper; 
	// 처음에 값이 안들어가 있으니 위에 autowired 줘서 값 삽입
	
	//1번 로그인 성공, 2번 아이디 없음, 3번 비번 틀림
	public int login(UserPARAM param) { // 아이디랑 비번 담김 / 비번 암호화 안된 상태
		if(param.getUser_id().equals("")) {
			return Const.NO_ID;
		}	
		UserDMI dbUser = mapper.selUser(param);
		
		if(dbUser == null) {
			return Const.NO_ID;
		}
		
		String cryptPw = SecurityUtils.getEncrypt(param.getUser_pw(), dbUser.getSalt());
		if(!cryptPw.equals(dbUser.getUser_pw())) {
			return Const.NO_PW;
		}
		
		param.setUser_pw(null);
		param.setNm(dbUser.getNm());
		param.setI_user(dbUser.getI_user());
		param.setProfile_img(dbUser.getProfile_img());
		return Const.SUCCESS;
	}
	
	public int join(UserVO param) {
		String pw = param.getUser_pw();
		String salt = SecurityUtils.generateSalt(); 
		String cryptPw = SecurityUtils.getEncrypt(pw, salt);
		
		param.setSalt(salt);
		param.setUser_pw(cryptPw);
		
		return mapper.insUser(param);
	}

	public int ajaxToggleFavorite(UserPARAM param) {//i_user, i_rest, proc_type
		switch(param.getProc_type()) {
		case "ins":
			return mapper.insFavorite(param);
		case "del":
			return mapper.delFavorite(param);
		}
		return 0;
	}
}
