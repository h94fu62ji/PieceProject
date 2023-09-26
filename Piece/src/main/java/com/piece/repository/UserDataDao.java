package com.piece.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piece.entity.UserData;

public interface UserDataDao extends JpaRepository<UserData, Integer>{
	
	@Query(value = "SELECT count(*) FROM piece_data.track_list WHERE track_id = :userId", nativeQuery = true)
	public int getTrackCount(@Param("userId")int userId);
	
	@Query(value = "SELECT count(*) FROM piece_data.track_list WHERE user_id = :userId", nativeQuery = true)
	public int getFansCount(@Param("userId")int userId);
}
