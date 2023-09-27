package com.piece.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piece.constants.RtnCode;
import com.piece.entity.User;
import com.piece.service.ifs.EmailService;
import com.piece.service.ifs.UserService;
import com.piece.vo.UserReq;
import com.piece.vo.UserRes;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;
	


	// Vue���f���ե�
	@GetMapping(value = "piece")
	public String piece() {
		return "�n�J...";
	}

	// Vue��f���ե�
	@GetMapping(value = "api")
	public String api() {
		return "Api�n�J...";
	}

	@GetMapping(value = "signup")
	public String getSinupPage() {
		return "���U���\";
	}
	
	
	//���U��
	@PutMapping(value ="addInfo")
	public UserRes addInfo(@RequestBody UserReq req) {
		UserRes res = userService.addInfo(new User(req.getAccount(),req.getPwd()));
		return res;
	}
	
	//�n�J��
	@PostMapping(value = "test01")
	public UserRes findByAccountAndPwd(@RequestBody UserReq req, HttpSession httpSession) {
	    String account = (String) httpSession.getAttribute("account");
	    if (StringUtils.hasText(account)) {
	        return new UserRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), account, req.getPwd());
	    }

	    UserRes res = userService.findByAccountAndPwd(req.getAccount(), req.getPwd());
	    if (!res.getCode().equals("200")) {
	   
	        return res;
	    }
	     httpSession.setAttribute("account", req.getAccount());
	        httpSession.setAttribute("pwd", req.getPwd());
	        httpSession.setMaxInactiveInterval(60);
	    return new UserRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage(),req.getAccount(),req.getPwd());
	}
	
	@PostMapping(value="email")
	 public String sendEmailMessage(@RequestParam String mail) {
	  this.emailService.sendMessage(
	   mail,"����","http://localhost:5173/piece/pwdnew"
	 
	  );
	  return "5555";
	 
	 }



//	@PostMapping(value="test01")
//	public UserRes findByAccountAndPwd(@RequestBody UserReq req,HttpSession httpSession) {
//	    String account=(String)httpSession.getAttribute("account");
//	    if(StringUtils.hasText(account)) {
//	    	
//			return new UserRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
//	    }
//	   
//	    
//	    UserRes res = userService.findByAccountAndPwd(req.getAccount(), req.getPwd());
//	    if (res != null && res.getCode() != null && res.getCode().equals("200")) {
//	        httpSession.setAttribute("account", req.getAccount());
//	        httpSession.setAttribute("pwd", req.getPwd());
//	        httpSession.setMaxInactiveInterval(60);
//	        return res; 
//	    } else {
//	        return res; 
//
//
//	}
//
//	}
}
