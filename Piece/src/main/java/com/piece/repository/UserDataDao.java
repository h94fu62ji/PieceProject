package com.piece.repository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piece.entity.UserData;

public interface UserDataDao extends JpaRepository<UserData, String> {

	// 取得追蹤數
	@Query(value = "SELECT count(*) FROM piece_data.track_list WHERE track_id = :account ;", nativeQuery = true)
	public int getTrackCount(@Param("account") String account);

	// 取得粉絲數
	@Query(value = "SELECT count(*) FROM piece_data.track_list WHERE account = :account ;", nativeQuery = true)
	public int getFansCount(@Param("account") String account);

	// 更新資料
	@Modifying
	@Transactional
	@Query(value = "UPDATE piece_data.user_data  SET user_name = :userName,  birthday = :birthday, address = :address, introduce = :introduce, sex = :sex "
			+ " WHERE account = :account ;", nativeQuery = true)
	public int updateInfo(@Param("account") String account, @Param("userName") String userName,
			@Param("birthday") LocalDate birthday, @Param("address") String address,
			@Param("introduce") String introduce, @Param("sex") String sex);

	// 檢查追蹤
	@Query(value = "SELECT count(*) FROM piece_data.track_list WHERE account = :user AND track_id = :userId ;", nativeQuery = true)
	public int checkTrack(@Param("user") String user, @Param("userId") String userId);

	// 新增追蹤
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO piece_data.track_list VALUE (:user, :userId);", nativeQuery = true)
	public int newTrack(@Param("user") String user, @Param("userId") String userId);

	// 刪除追蹤
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM piece_data.track_list WHERE account = :user AND track_id = :userId ;", nativeQuery = true)
	public int delTrack(@Param("user") String user, @Param("userId") String userId);
}
