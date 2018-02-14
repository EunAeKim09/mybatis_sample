package kr.or.dgit.mybatis_sample.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Course;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class CourseService {
	private static final Log log = LogFactory.getLog(CourseService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.CourseDao.";
	
	public 	List<Course> selectCoursesByConditionWithAPI(Map<String, Object> map){
		log.debug("selectCoursesByConditionWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectCoursesByConditionWithAPI", map);
		}
	}
	
	public List<Course> selectCaseCoursesWithAPI(Map<String, Object> map){
		log.debug("selectCaseCoursesWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectCaseCoursesWithAPI", map);
		}
	}
	
	public List<Course> selectWhereCoursesWithAPI(Map<String, Object> map){
		log.debug("selectWhereCoursesWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectWhereCoursesWithAPI", map);
		}
	}
	
	public List<Course> selectTrimCoursesWithAPI(Map<String, Object> map){
		log.debug("selectTrimCoursesWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectTrimCoursesWithAPI", map);
		}
	}
	
	public List<Course> selectCoursesForeachByTutorsWithAPI(Map<String, Object> map){
		log.debug("selectCoursesForeachByTutorsWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectCoursesForeachByTutorsWithAPI", map);
		}
	}
}
