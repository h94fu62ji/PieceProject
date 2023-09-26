package com.piece.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.piece.repository.UserDataDao;
import com.piece.service.ifs.PostService;
import com.piece.vo.GetImgRes;
import com.piece.vo.GetPostListRes;
import com.piece.vo.GetPostRes;
import com.piece.vo.GetTrackRes;
import com.piece.vo.GetUserDataRes;
import com.piece.vo.IdReq;
import com.piece.vo.NewPostReq;
import com.piece.vo.NewPostRes;

@CrossOrigin
@RestController
public class PieceController {
	@Autowired
	private PostService postService;
	@Autowired
	private UserDataDao userDataDao;

	@PostMapping(value = "/new_post")
	public NewPostRes newPost(@RequestBody NewPostReq req) {
		return postService.newPost(req.getSender_id(), req.getText(), req.getPic64(), req.isPub());
	}

	@PostMapping(value = "/get_post_by_post_id")
	public GetPostRes getPostById(@RequestBody IdReq req) {
		return postService.getPostById(req.getId());
	}

	@PostMapping(value = "/get_pic_by_img_id")
	public GetImgRes getImgById(@RequestBody IdReq req) {
		return postService.getImgById(req.getId());
	}

	@PostMapping(value = "/get_post_list")
	public GetPostListRes getPostList(@RequestBody IdReq req) {
		return postService.getPostList(req.getId());
	}

	@PostMapping(value = "/get_user_data")
	public GetUserDataRes getUserData(@RequestBody IdReq req) {
		return postService.getUserData(req.getId());
	}
	
	@PostMapping(value = "/get_track_me")
	public GetTrackRes getTrack(@RequestBody IdReq req) {
		return postService.getTrack(req.getId());
	}


}
