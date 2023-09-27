package com.piece.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piece.entity.UserData;

public interface UserDataDao extends JpaRepository<UserData, String>{
	
	@Query(value = "SELECT count(*) FROM piece_data.track_list WHERE track_id = :account", nativeQuery = true)
	public int getTrackCount(@Param("account")String account);
	
	@Query(value = "SELECT count(*) FROM piece_data.track_list WHERE account = :account", nativeQuery = true)
	public int getFansCount(@Param("account")String account);
}
