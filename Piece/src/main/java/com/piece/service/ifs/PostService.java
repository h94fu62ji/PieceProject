package com.piece.service.ifs;

import com.piece.vo.GetImgRes;
import com.piece.vo.GetPostListRes;
import com.piece.vo.GetPostRes;
import com.piece.vo.NewPostRes;

public interface PostService {
	public NewPostRes newPost(int senderId, String text, String picId, boolean pub);

	public GetPostRes getPostById(int postId);

	public GetImgRes getImgById(int imgId);

	public GetPostListRes getPostList(int userId);

}
