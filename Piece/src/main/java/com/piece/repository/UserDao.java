package com.piece.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.piece.entity.User;
import com.piece.entity.UserId;

@Repository
public interface UserDao extends JpaRepository<User, UserId> {
	//=======================================================
	User findByAccount(String account);
//
//	public List<User> findAll();
	//public int editByAccount(UserDto userDto);
	//public int save(UserDto userDto);

	//以上先不理
	//=======================================================
	
	//TODO 登入 account pwd
	//TODO 新增 account pwd  
	//TODO 忘記密碼 account 去收信 => 才能輸入新密碼
	//TODO 更新密碼
	
	//新增(insert)
	@Modifying
	@Transactional
	@Query(value = "insert into piece_data.user_info(account,pwd) values(:paramAccount ,:paramPwd)",nativeQuery = true)
	public int insertInfo(@Param("paramAccount") String account,@Param("paramPwd") String pwd);
	
	//查詢(select)
//	@Query(value= "SELECT account,pwd FROM piece_data.user_info WHERE account =:paramAccount AND pwd =:paramAPwd", nativeQuery = true)
//	public UserRes findByAccountAndPwd(@Param("paramAccount") String account,@Param("paramAPwd")String pwd);
	
	public boolean existsByAccountAndPwd(String account, String pwd);
	
	//更新(update)
	@Modifying
	@Transactional
	@Query(value = "update piece_data.user_info set pwd=?2 where account=?1",nativeQuery = true)
	public int updateByPwd(String account,String pwd);
	

}
