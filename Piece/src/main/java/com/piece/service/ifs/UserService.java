package com.piece.service.ifs;

import com.piece.entity.User;
import com.piece.vo.UserRes;

public interface UserService {
	
//	User save(UserDto userDto);
	public UserRes findall(User user);
//	public UserDto editByAccount(UserDto userDto);
//	public UserDto save2(UserDto userDto);
	public UserRes addInfo(User user);
	
	//�H�W�����z
	//===================================================
	
	public UserRes  insertInfo(User user);
	public UserRes findByAccountAndPwd(String account, String pwd);
	public User updateByPwd(User user, String newPwd);
	


	
	
	

}
