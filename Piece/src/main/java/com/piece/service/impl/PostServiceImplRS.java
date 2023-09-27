package com.piece.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piece.repository.LikeCountDao;
import com.piece.repository.PostDao;
import com.piece.repository.PostMesgDao;
import com.piece.repository.UserDataDao;
import com.piece.service.ifs.PostServiceRS;

@Service
public class PostServiceImplRS implements PostServiceRS {

	@Autowired
	private PostDao postDao;

	@Autowired
	private PostMesgDao postMesgDao;

	@Autowired
	private UserDataDao userDataDao;

	@Autowired
	private LikeCountDao likeCountDao;



	// ���票�����
//	@Override
//	public GetPostResponse getPost(int postId) {
//		Optional<Post> op = postDao.findById(postId);
//		if (op == null) {
//			new GetPostResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
//		}
//		Post postInfo = op.get();
//
//		return new GetPostResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), postInfo);
//	}
//
//	// ���票�����鞈��
//	@Override
//	public GetCommendResponse getPostCommend(int messageId) {
//		Optional<PostMesg> op = postMesgDao.findById(messageId);
//		if (op == null) {
//			new GetCommendResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
//		}
//		PostMesg commendInfo = op.get();
//		System.out.println(commendInfo.getText());
//		return new GetCommendResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), commendInfo);
//	}
//
//	// ���ser鞈��
//	@Override
//	public GetUserInfoResponse getUserInfo(int userId) {
//		Optional<UserData> op = userDataDao.findById(userId);
//		if (op == null) {
//			new GetUserInfoResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
//		}
//		UserData userInfo = op.get();
//		return new GetUserInfoResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), userInfo);
//	}
//
//	// ����
//	@Override
//	public addLikeResponse plusLike(LikeCount postIdAndUserId) {
//		// �������蝛�
//		if (postIdAndUserId == null) {
//			return new addLikeResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
//		}
//		// ����鞎潭��摮
//		int resPost = likeCountDao.postSerach(postIdAndUserId.getPostMesgId());
//		if (resPost != 1) {
//			return new addLikeResponse(RtnCode.DATA_ERROR.getCode(), "This post does not exist");
//		}
//
//		// ����雿輻��摮
//		int resUserId = likeCountDao.userSerach(postIdAndUserId.getUserId());
//		if (resUserId != 1) {
//			return new addLikeResponse(RtnCode.DATA_ERROR.getCode(), "This user does not exist");
//		}
//
//		// �����”鋆⊿�閬���閬�����
//		int resNum = likeCountDao.dataSerach(postIdAndUserId.getPostMesgId(), postIdAndUserId.getUserId());
//		if (resNum != 1) {
//			// ����(�憓票���serId)
//			LikeCount res = likeCountDao.save(postIdAndUserId);
//			// ���+1
//			likeCountDao.likePlusone(postIdAndUserId.getPostMesgId());
//			return new addLikeResponse(RtnCode.SUCCESSFUL.getCode(), "like", res);
//		} else {
//			// ����(��鞎潭��serId)
//			likeCountDao.dataDelete(postIdAndUserId.getPostMesgId(), postIdAndUserId.getUserId());
//			// ���-1
//			likeCountDao.likeMinusone(postIdAndUserId.getPostMesgId());
//			return new addLikeResponse(RtnCode.SUCCESSFUL.getCode(), "unlike");
//		}
//
//	}
//
//	// �蝝������票���/�������
//	@Override
//	public int likeYesOrNo(LikeCount postIdAndUserId) {
//		return likeCountDao.dataSerach(postIdAndUserId.getPostMesgId(), postIdAndUserId.getUserId());
//	}
//
//	// �������
//	@Override
//	public addLikeResponse plusCommendLike(LikeCount postIdAndUserId) {
//		// �������蝛�
//		if (postIdAndUserId == null) {
//			return new addLikeResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
//		}
//		// ���������摮
//		int resCommendId = likeCountDao.commendSerach(postIdAndUserId.getPostMesgId());
//		if (resCommendId != 1) {
//			return new addLikeResponse(RtnCode.DATA_ERROR.getCode(), "This commend does not exist");
//		}
//		// ����雿輻��摮
//		int resUserId = likeCountDao.userSerach(postIdAndUserId.getUserId());
//		if (resUserId != 1) {
//			return new addLikeResponse(RtnCode.DATA_ERROR.getCode(), "This user does not exist");
//		}
//		// �����”鋆⊿�閬���閬�����
//		int resNum = likeCountDao.dataSerach(postIdAndUserId.getPostMesgId(), postIdAndUserId.getUserId());
//		if (resNum != 1) {
//			// ����(�憓票���serId)
//			LikeCount res = likeCountDao.save(postIdAndUserId);
//			// ������+1
//			likeCountDao.commendLikePlusone(postIdAndUserId.getPostMesgId());
//			return new addLikeResponse(RtnCode.SUCCESSFUL.getCode(), "like", res);
//		} else {
//			// ����(��鞎潭��serId)
//			likeCountDao.dataDelete(postIdAndUserId.getPostMesgId(), postIdAndUserId.getUserId());
//			// ���-1
//			likeCountDao.commendLikeMinusone(postIdAndUserId.getPostMesgId());
//			return new addLikeResponse(RtnCode.SUCCESSFUL.getCode(), "unlike");
//		}
//		
//	}

}
