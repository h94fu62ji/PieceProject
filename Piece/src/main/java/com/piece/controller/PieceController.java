package com.piece.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.piece.service.ifs.PostService;
import com.piece.vo.GetImgReq;
import com.piece.vo.GetImgRes;
import com.piece.vo.GetPostListReq;
import com.piece.vo.GetPostListRes;
import com.piece.vo.GetPostReq;
import com.piece.vo.GetPostRes;
import com.piece.vo.NewPostReq;
import com.piece.vo.NewPostRes;

@CrossOrigin
@RestController
public class PieceController {
	@Autowired
	private PostService postService;
//	@Autowired
//	private PostDao postDao;

	@PostMapping(value = "/new_post")
	public NewPostRes newPost(@RequestBody NewPostReq req) {
		return postService.newPost(req.getSender_id(), req.getText(), req.getPic64(), req.isPub());
	}

	@PostMapping(value = "/get_post_by_post_id")
	public GetPostRes getPostById(@RequestBody GetPostReq req) {
		return postService.getPostById(req.getPostId());
	}

	@PostMapping(value = "/get_pic_by_img_id")
	public GetImgRes getImgById(@RequestBody GetImgReq req) {
		return postService.getImgById(req.getImgId());
	}

	@PostMapping(value = "/get_post_list")
	public GetPostListRes getPostList(@RequestBody GetPostListReq req) {
		return postService.getPostList(req.getUserId());
	}

}
