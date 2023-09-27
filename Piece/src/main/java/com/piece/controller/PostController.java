package com.piece.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.piece.service.ifs.PostService;

@CrossOrigin
@RestController
//@Controller
public class PostController {

	@Autowired
	private PostService postService;


//	@GetMapping(value = "post/get")
//	public GetPostResponse getPost(@RequestParam int limit) {
//		return postService.getPost(limit);
//
//	}
//
//	// �����鞈�瘜�
//	@GetMapping(value = "post/get/commend/{commendId}")
//	public GetCommendResponse getPostCommend(@PathVariable("commendId") int commendId) {
//		return postService.getPostCommend(commendId);
//	}
//	
//	//���ser鞈�瘜�
//	@GetMapping(value = "user/get/info")
//	public GetUserInfoResponse getUserInfo(@RequestParam int take) {
//		return postService.getUserInfo(take);
//	}
//
//	//摮鞎潭������誑����+1����-1
//	@PostMapping(value = "add/like/info")
//	public addLikeResponse plusLike(@RequestBody addLikeRequest Req) {
//		return postService.plusLike(new LikeCount(Req.getPostId(),Req.getUserId()));
//		
//	}
//	
//	//敺��澈����撌脩����
//	@PostMapping(value = "like/yes/or/no")
//	public int likeYesOrNo(@RequestBody addLikeRequest Req) {
//		return postService.likeYesOrNo(new LikeCount(Req.getPostId(),Req.getUserId()));
//		
//	}
//	
//	//摮���������誑����+1����-1
//	@PostMapping(value = "add_commend_like_info")
//	public addLikeResponse plusCommendLike(@RequestBody addLikeRequest Req) {
//		return postService.plusCommendLike(new LikeCount(Req.getPostId(),Req.getUserId()));
//		
//	}
//	
	
	

	
}
