package com.piece.service.ifs;

import com.piece.vo.GetImgRes;
import com.piece.vo.GetPostListRes;
import com.piece.vo.GetPostRes;
import com.piece.vo.GetTrackRes;
import com.piece.vo.GetUserDataRes;
import com.piece.vo.NewPostRes;

public interface PostService {
	public NewPostRes newPost(String senderId, String text, String picId, boolean pub);

	public GetPostRes getPostById(int postId);

	public GetImgRes getImgById(int imgId);

	public GetPostListRes getPostList(String userId);
	
	public GetUserDataRes getUserData(String userId);
	
	public GetTrackRes getTrack(String userId);




}
