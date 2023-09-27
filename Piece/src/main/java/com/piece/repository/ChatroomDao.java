package com.piece.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piece.entity.Chatroom;

public interface ChatroomDao extends JpaRepository<Chatroom, Integer>{

	@Query(value = "select c from Chatroom as c "
			+ " where user1 = :currentUserId "
			+ " or user2 = :currentUserId")
	public List<Chatroom> findByUser1OrUser2(@Param("currentUserId") String currentUserId);
	

	public Chatroom findByChatroomId(int chatId);
}
