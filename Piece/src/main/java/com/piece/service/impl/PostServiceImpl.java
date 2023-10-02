package com.piece.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.piece.constants.RtnCode;
import com.piece.entity.Pic;
import com.piece.entity.UserData;
import com.piece.repository.PicDao;
import com.piece.repository.PostDao;
import com.piece.repository.UserDataDao;
import com.piece.service.ifs.PostService;
import com.piece.vo.GetImgRes;
import com.piece.vo.GetPostByIdVo;
import com.piece.vo.GetPostListRes;
import com.piece.vo.GetPostRes;
import com.piece.vo.GetTrackRes;
import com.piece.vo.GetUserDataRes;
import com.piece.vo.NewPostRes;
import com.piece.vo.Res;
import com.piece.vo.UpdataRes;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	@Autowired
	private PicDao picDao;

	@Autowired
	private UserDataDao userDataDao;

//	@Autowired
//	private TrackDao trackDao;

	@Override
	public NewPostRes newPost(String senderId, String text, String pic64, boolean pub) { // 新增貼文
		if (!StringUtils.hasText(senderId) || !StringUtils.hasText(text) || !StringUtils.hasText(pic64)) {
			return new NewPostRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		// 存檔位置
		String address = "C:/Users/minic/OneDrive/Desktop/PieceProject/Piece/img/";
		// 新增至資料庫 取得自動增長ID
		Pic res = picDao.save(new Pic(address));
		// 更新資料庫
		String pic64Type = pic64.split("/|;")[1]; // 抓副檔名
		picDao.save(new Pic(res.getPicId(), address + res.getPicId() + "." + pic64Type));
		// 儲存圖片到本地
		if (!saveImg(pic64, res.getPicId(), address)) {
			return new NewPostRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		if (postDao.newPost(senderId, text, res.getPicId(), pub) == 0) {
			return new NewPostRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		System.out.println("新增成功");
		return new NewPostRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res.getPicId());
	}

	private boolean saveImg(String base64ImageAll, int pic_id, String picAdd) { // 儲存圖片至本地
		try {
			String base64Type = base64ImageAll.split("/|;")[1];
			String base64Image = base64ImageAll.split(",")[1];
			// 解碼Base64轉成JPEG文件
			byte[] imageBytes = Base64.getDecoder().decode(base64Image);

			// 指定JPEG儲存路徑 (位置 檔案名 資料型態)
			String outputPath = picAdd + pic_id + "." + base64Type;
			System.out.println(outputPath);

			// 創建文件輸出並將其寫入文件
			FileOutputStream imageOutputStream = new FileOutputStream(outputPath, true);
			imageOutputStream.write(imageBytes);
			imageOutputStream.close();

			System.out.println("圖片成功儲存成功: " + outputPath);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return false;
		}

	}

	@Override
	public GetPostRes getPostById(int postId) {
		GetPostByIdVo res = postDao.getPost(postId);
		return new GetPostRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}

	@Override
	public GetImgRes getImgById(int imgId) {
		// 找度圖片地址
		Optional<Pic> res = picDao.findById(imgId);
		String imagePath = res.get().getPicAdd();
		try {
			// 讀取圖像
			File imageFile = new File(imagePath);
			FileInputStream imageInputStream = new FileInputStream(imageFile);
			System.out.println();
			// 創建緩衝空間
			byte[] imageBytes = new byte[(int) imageFile.length()];
			imageInputStream.read(imageBytes);
			imageInputStream.close();

			// 轉成Base64
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);

			String resString = "data:image/" + imagePath.split("\\.")[imagePath.split("\\.").length - 1] + ";base64,"
					+ base64Image;
			return new GetImgRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), resString);
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e);
			return new GetImgRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), null);
		}

	}

	@Override
	public GetPostListRes getPostList(String userId) {
		if (!StringUtils.hasText(userId)) {
			List<String> res = postDao.getPostList();
			return new GetPostListRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
		}
		List<String> res = postDao.getPostListById(userId);
		return new GetPostListRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}

	@Override
	public GetUserDataRes getUserData(String userId) {
		if (!StringUtils.hasText(userId)) {
			return new GetUserDataRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), null);
		}
		Optional<UserData> res = userDataDao.findById(userId);
		return new GetUserDataRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res.get());
	}

	@Override
	public GetTrackRes getTrack(String userId) {
		if (!StringUtils.hasText(userId)) {
			return new GetTrackRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		int track = userDataDao.getTrackCount(userId);
		int fans = userDataDao.getFansCount(userId);
		return new GetTrackRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), track, fans);
	}

	@Override
	public UpdataRes updataUserData(String userId, String userName, LocalDate birthday, String address,
			String introduce, String sex) {
		int res = userDataDao.updateInfo(userId, userName, birthday, address, introduce, sex);
		if (res == 0) {
			return new UpdataRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		return new UpdataRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public int checkTrack(String user, String userId) {
		return userDataDao.checkTrack(user, userId);
	}

	@Override
	public Res newTrack(String user, String userId) {
		int res = userDataDao.newTrack(user, userId);
		if (res == 0) {
			return new Res(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		return new Res(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public Res delTrack(String user, String userId) {
		int res = userDataDao.delTrack(user, userId);
		if (res == 0) {
			return new Res(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage());
		}
		return new Res(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

}
