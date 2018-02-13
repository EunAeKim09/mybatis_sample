package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.UserPic;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class UserPicService {
	private static final Log log = LogFactory.getLog(UserPicService.class);
	
	private static String namespace = "kr.or.dgit.mybatis_sample.dao.UserPicDao.";
	
	public int insertUserPicWithAPI(UserPic userPic) {
		log.debug("insertUserPicWithAPI()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		int res=-1;
		try{
			res=sqlSession.insert(namespace+"insertUserPicWithAPI", userPic);
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
	
	public UserPic getUserPicWithAPI(int id) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace+"getUserPicWithAPI", id);
		}
	}
}	
