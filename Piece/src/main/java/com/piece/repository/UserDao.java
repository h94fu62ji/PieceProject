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

	//�H�W�����z
	//=======================================================
	
	//TODO �n�J account pwd
	//TODO �s�W account pwd  
	//TODO �ѰO�K�X account �h���H => �~���J�s�K�X
	//TODO ��s�K�X
	
	//�s�W(insert)
	@Modifying
	@Transactional
	@Query(value = "insert into piece_data.user_info(account,pwd) values(:paramAccount ,:paramPwd)",nativeQuery = true)
	public int insertInfo(@Param("paramAccount") String account,@Param("paramPwd") String pwd);
	
	//�d��(select)
//	@Query(value= "SELECT account,pwd FROM piece_data.user_info WHERE account =:paramAccount AND pwd =:paramAPwd", nativeQuery = true)
//	public UserRes findByAccountAndPwd(@Param("paramAccount") String account,@Param("paramAPwd")String pwd);
	
	public boolean existsByAccountAndPwd(String account, String pwd);
	
	//��s(update)
	@Modifying
	@Transactional
	@Query(value = "update piece_data.user_info set pwd=?2 where account=?1",nativeQuery = true)
	public int updateByPwd(String account,String pwd);
	

}
