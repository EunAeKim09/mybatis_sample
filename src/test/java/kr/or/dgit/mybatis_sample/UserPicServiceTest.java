package kr.or.dgit.mybatis_sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.UserPic;
import kr.or.dgit.mybatis_sample.service.UserPicService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPicServiceTest {
	private static UserPicService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new UserPicService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1InsertUserPicWithAPI() {
		UserPic userPic = new UserPic();
		userPic.setName("HanJiMin");
		userPic.setBio("put some lengthy bio here");
		userPic.setPic(getPicFile());
		
		int result = service.insertUserPicWithAPI(userPic);
		Assert.assertSame(1, result);
	}

	private byte[] getPicFile() {
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir")+"\\DateFiles\\hanjimin.jpg");
		try {
			InputStream is = new FileInputStream(file);
			pic = new byte[is.available()];
			is.read(pic);
			is.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	@Test
	public void test2getUserPicWithAPI() {
		UserPic userPic = service.getUserPicWithAPI(1);
		Assert.assertNotNull(userPic);
	}
}
