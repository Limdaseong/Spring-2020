package com.koreait.matzip.user;

import org.apache.ibatis.annotations.Mapper;

import com.koreait.matzip.user.model.UserDMI;
import com.koreait.matzip.user.model.UserPARAM;
import com.koreait.matzip.user.model.UserVO;

@Mapper // 마이바티스가 스캔함
public interface UserMapper {
	public int insUser(UserVO p); // 이름은 아무 상관 없음
	public int insFavorite(UserPARAM param);  
	
	public UserDMI selUser(UserPARAM p); // 파라미터에는 parameterType에 적혀진 것을 적어야 함
	// 여기에 하나 써놓으면 xml에 db문이 있어야함
	int delFavorite(UserPARAM param);
}
