package kr.or.dgit.mybatis_sample.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.StudentDao;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class StudentService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	
	private String namespace = "kr.or.dgit.mybatis_sample.dao.StudentDao.";
	
	public Student findStudentByNoWidthAPI(Student student) {
		log.debug("selectStudentByNoWidthAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace+"selectStudentByNoWidthAPI", student);
		}
	}
	
	public List<Student> selectStudentByAllWidthAPI() {
		log.debug("selectStudentByAllWidthAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectStudentByAllWidthAPI");
		}
	}
	
	public int insertStudentWidthAPI(Student student) {
		log.debug("insertStudentWidthAPI()");
		int res=-1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			res=sqlSession.insert(namespace+"insertStudentWidthAPI", student);
			sqlSession.commit();
		}
		return res;
	}
}
