package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.UserPicDao;
import kr.or.dgit.mybatis_sample.dto.UserPic;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class UserPicService {
	private static final Log log = LogFactory.getLog(UserPicService.class);
	
	public int insertUserPic(UserPic userPic) {
		log.debug("insertUserPic()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		int res = -1;
		try{
			UserPicDao userPicDao = sqlSession.getMapper(UserPicDao.class);
			res = userPicDao.insertUserPic(userPic);
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally {
			sqlSession.close();
		}
		return res;
	}
	
	public UserPic getUserPic(int id) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			UserPicDao userPicDao = sqlSession.getMapper(UserPicDao.class);
			return userPicDao.getUserPic(id);
		}
	}
	
	
}