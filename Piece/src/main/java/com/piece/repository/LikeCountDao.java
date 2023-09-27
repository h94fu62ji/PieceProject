package com.piece.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.piece.entity.LikeCount;
@Repository
public interface LikeCountDao extends JpaRepository<LikeCount, Integer> {
	
	//JPQL
	//去撈按讚表的資料
	@Query(value = "SELECT COUNT(id) FROM piece_data.like_count "
			+ " where post_mesg_id = :postId and user_id = :userId",nativeQuery = true)
	public int dataSerach(@Param("postId")int postId, @Param("userId")int userId);
	
	//刪除按讚資訊
	@Modifying
	@Transactional
	@Query(value = "delete from piece_data.like_count "
			+ " where post_mesg_id = :postId and user_id = :userId",nativeQuery = true)
	public int dataDelete(@Param("postId")int postId, @Param("userId")int userId);
	
	//查詢貼文是否存在
	@Query(value = "SELECT COUNT(post_id) FROM piece_data.post"
			+ " where post_id = :postId",nativeQuery = true)
	public int postSerach(@Param("postId")int postId);
	
	//查詢使用者是否存在
	@Query(value = "SELECT COUNT(user_id) FROM piece_data.user_data"
			+ " where user_id = :userId",nativeQuery = true)
	public int userSerach(@Param("userId")int userId);
	
	//查詢留言是否存在
	@Query(value = "SELECT COUNT(mesg_id) FROM piece_data.post_mesg"
			+ " where mesg_id = :commendId",nativeQuery = true)
	public int commendSerach(@Param("commendId")int commendId);
	
	//貼文讚數+1
	@Modifying
	@Transactional
	@Query(value = "update piece_data.post set `up` = `up`+1 where post_id = :postId",nativeQuery = true)
	public int likePlusone(@Param("postId")int postId);
	
	//貼文讚數-1
	@Modifying
	@Transactional
	@Query(value = "update piece_data.post set `up` = `up`-1 where post_id = :postId",nativeQuery = true)
	public int likeMinusone(@Param("postId")int postId);

	//留言讚數+1
	@Modifying
	@Transactional
	@Query(value = "update piece_data.post_mesg set `up` = `up`+1 where mesg_id = :postId",nativeQuery = true)
	public int commendLikePlusone(@Param("postId")int postId);
	
	//留言讚數-1
	@Modifying
	@Transactional
	@Query(value = "update piece_data.post_mesg set `up` = `up`-1 where mesg_id = :postId",nativeQuery = true)
	public int commendLikeMinusone(@Param("postId")int postId);
	

	
	
}
