package kr.or.dgit.mybatis_sample.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class StudentService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	
	private static String namespace = "kr.or.dgit.mybatis_sample.dao.StudentDao.";
	
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
	
	public int insertEnumStudentWithAPI(Student student) {
		log.debug("insertEnumStudentWithAPI()");
		int res=-1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			res=sqlSession.insert(namespace+"insertEnumStudentWithAPI", student);
			sqlSession.commit();
		}
		return res;
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
	
	public static int updateStudnetWithAPI(Student student) {
		log.debug("updateStudnetWithAPI()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			int res=sqlSession.update(namespace+"updateStudnetWithAPI", student);
			sqlSession.commit();
			return res;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sqlSession.close();
		}
	}
	
	public static int deleteStudentWithApI(int id) {
		log.debug("deleteStudentWithApI()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			int res=sqlSession.delete(namespace+"deleteStudentWithAPI", id);
			sqlSession.commit();
			return res;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally {
			sqlSession.close();
		}
	}
	
	public List<Student> selectStudentByAllForResultMapWithAPI() {
		log.debug("selectStudentByAllForResultMapWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectStudentByAllForResultMapWithAPI");
		}
	}
	
	public List<Map<String, Object>> selectStudentByAllForHashMapWithAPI() {
		log.debug("selectStudentByAllForHashMapWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectStudentByAllForHashMapWithAPI");
		}
	}
	
	public Student selectStudentByNoForResultExtendsWithAPI(Student student) {
		log.debug("selectStudentByNoForResultExtendsWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace+"selectStudentByNoForResultExtendsWithAPI", student);
		}
	}
	
	public Student selectStudentByNoAssociation(Student student) {
		log.debug("selectStudentByNoAssociation()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace+"selectStudentByNoAssociation", student);
		}
	}
}
