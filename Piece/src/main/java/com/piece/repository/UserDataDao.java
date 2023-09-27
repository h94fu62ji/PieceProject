package com.piece.repository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piece.entity.UserData;

public interface UserDataDao extends JpaRepository<UserData, String> {

	@Query(value = "SELECT count(*) FROM piece_data.track_list WHERE track_id = :account", nativeQuery = true)
	public int getTrackCount(@Param("account") String account);

	@Query(value = "SELECT count(*) FROM piece_data.track_list WHERE account = :account", nativeQuery = true)
	public int getFansCount(@Param("account") String account);

	@Modifying
	@Transactional
	@Query(value = "UPDATE piece_data.user_data  SET user_name = :userName,  birthday = :birthday, address = :address, introduce = :introduce, sex = :sex "
			+ " WHERE account = :account ;", nativeQuery = true)
	public int updateInfo(@Param("account") String account, @Param("userName") String userName,
			@Param("birthday") LocalDate birthday, @Param("address") String address,
			@Param("introduce") String introduce, @Param("sex") String sex);
}
