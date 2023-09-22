package com.piece.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piece.entity.Message;

public interface MessageDao extends JpaRepository<Message, Integer>{

//	@Query(value = "select * from message as m "
//			+ " where m.chatroomId = :chatroomId "
//			+ " limit 1", nativeQuery = true)
//	public Message getLastMsgInChatroom(@Param("chatroomId") int chatroomId);
	
	@Query(value = "select m from Message as m "
			+ " where m.chatroomId = :chatroomId")
	public List<Message> getAllMsgInChatroom(@Param("chatroomId") int chatroomId);
}
