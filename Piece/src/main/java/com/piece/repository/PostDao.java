package com.piece.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piece.entity.Post;
import com.piece.vo.GetPostByIdVo;

public interface PostDao extends JpaRepository<Post, Integer> {

	// 新增貼文
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO piece_data.post(sender_id,text,pic_id,public) VALUE (:senderId,:text,:picId,:pub);", nativeQuery = true)
	public int newPost(@Param("senderId") String senderId, @Param("text") String text, @Param("picId") int picId,
			@Param("pub") boolean pub);

	// 搜尋貼文
	@Query(value = "SELECT new com.piece.vo.GetPostByIdVo(p.senderId, p.picId, u.picId, p.text, p.up, p.time) "
			+ " FROM Post p JOIN UserData u ON p.senderId = u.account WHERE p.postId = :postId")
	public GetPostByIdVo getPost(@Param("postId") int postId);
	
	// 取得貼文列表
	@Query(value = "SELECT post_id FROM post WHERE public = FALSE ORDER BY time DESC;", nativeQuery = true)
	public List<String> getPostList();
	
	// 取得特定貼文列表
	@Query(value = "SELECT post_id FROM post WHERE sender_id = :userId AND public = FALSE ORDER BY time DESC;", nativeQuery = true)
	public List<String> getPostListById(@Param("userId") String userId);
	
}
