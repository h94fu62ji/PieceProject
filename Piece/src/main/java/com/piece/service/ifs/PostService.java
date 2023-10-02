package com.piece.service.ifs;

import java.time.LocalDate;

import com.piece.vo.GetImgRes;
import com.piece.vo.GetPostListRes;
import com.piece.vo.GetPostRes;
import com.piece.vo.GetTrackRes;
import com.piece.vo.GetUserDataRes;
import com.piece.vo.NewPostRes;
import com.piece.vo.Res;
import com.piece.vo.UpdataRes;

public interface PostService {
	public NewPostRes newPost(String senderId, String text, String picId, boolean pub);

	public GetPostRes getPostById(int postId);

	public GetImgRes getImgById(int imgId);

	public GetPostListRes getPostList(String userId);

	public GetUserDataRes getUserData(String userId);

	public GetTrackRes getTrack(String userId);

	public UpdataRes updataUserData(String userId, String userName, LocalDate birthday, String address,
			String introduce, String sex);

	public int checkTrack(String user, String userId);

	public Res newTrack(String user, String userId);

	public Res delTrack(String user, String userId);

}
