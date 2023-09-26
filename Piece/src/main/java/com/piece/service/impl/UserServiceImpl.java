package com.piece.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.piece.constants.RtnCode;
import com.piece.entity.User;
import com.piece.repository.UserDao;
import com.piece.service.ifs.UserService;
import com.piece.vo.UserRes;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

//	@Override
//	public UserRes addInfo(User user) {
//		if(user==null) {
//			return new UserRes(user, RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
//		}
//		if(!StringUtils.hasText(user.getAccount()) || !StringUtils.hasText(user.getPwd())) {
//			return new UserRes(user,RtnCode.DATA_ERROR.getCode(),RtnCode.DATA_ERROR.getMessage());
//		}
//		//�b���s�b�n��@@
//		if(user.getAccount().equals(user.getAccount())) {
//			return new UserRes(user,RtnCode.ACCOUNT_EXISTED.getCode(),RtnCode.ACCOUNT_EXISTED.getMessage());
//		}
//		userDao.save(user);
//		
//		return new UserRes(user,RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
//	}

	// �H�W�����z
	// ==================================================================

	// ���U�Ϊ�
	@Override
	public UserRes addInfo(User user) {
		if (user == null || !StringUtils.hasText(user.getAccount()) || !StringUtils.hasText(user.getPwd())) {
			return new UserRes(user, RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}

		User checkUser = userDao.findByAccount(user.getAccount());
		if (checkUser != null) {
			return new UserRes(user, RtnCode.ACCOUNT_EXISTED.getCode(), RtnCode.ACCOUNT_EXISTED.getMessage());
		}

		userDao.save(user);
		return new UserRes(user, RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public UserRes insertInfo(User user) {

		userDao.save(user);
		return new UserRes();

	}

	// �n�J�Ϊ�
	@Override
	public UserRes findByAccountAndPwd(String account, String pwd) {
		boolean res = userDao.existsByAccountAndPwd(account, pwd);
		if (res == false) {
			return new UserRes(RtnCode.ACCOUNT_NOT_FOUND.getCode(), RtnCode.ACCOUNT_NOT_FOUND.getMessage(), account, pwd);
		}
		return new UserRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), account, pwd);
	}

	@Override
	public User updateByPwd(User user, String newPwd) {

		user.setPwd(newPwd);
		return userDao.save(user);
	}

	@Override
	public UserRes findall(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
