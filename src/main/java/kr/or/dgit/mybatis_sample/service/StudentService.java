package kr.or.dgit.mybatis_sample.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class StudentService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	
<<<<<<< HEAD
	public Student findStudentByNo(Student student) {
		log.debug("selectStudentByNo()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNo(student);
		}
	}
	
	public List<Student> selectStudentByAll() {
		log.debug("selectStudentByAll()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAll();
		}
	}
=======
	private static String namespace = "kr.or.dgit.mybatis_sample.dao.StudentDao.";
>>>>>>> refs/heads/hotfix_mapResult
	
<<<<<<< HEAD
	public int insertStudent(Student student) {
		log.debug("insertStudent()");
		int res = -1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			res=studentDao.insertStudent(student);
			sqlSession.commit();
		}
		return res;
	}
	
	public static int updateStudent(Student student) {
		log.debug("updateStudent()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		int res = -1;
		try{
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			res=studentDao.updateStudent(student);
=======
	public Student findStudentByNoWidthAPI(Student student) {
		log.debug("selectStudentByNoWidthAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace+"selectStudentByNoWidthAPI", student);
		}
	}
	
	public static List<Student> selectStudentByAllWidthAPI() {
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
>>>>>>> refs/heads/hotfix_mapResult
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
	
<<<<<<< HEAD
	public static int deleteStudent(int id) {
		log.debug("deleteStudent()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			int res=studentDao.deleteStudent(id);
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
	
=======
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
	
	public static List<Student> selectStudentByAllForResultMap(){
		log.debug("selectStudentByAllForResultMap()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectStudentByAllForResultMap");
		}
	}
>>>>>>> refs/heads/hotfix_mapResult
}
