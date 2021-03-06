package kr.or.dgit.mybatis_sample.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.StudentDao;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class StudentService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	
	public Student findStudentByNo(Student student) {
		log.debug("findStudentByNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNo(student);
		}
	}

	public List<Student> findStudentByAll() {
		log.debug("findStudentByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAll();
		}
	}

	
	public int createStudent(Student student) {
		log.debug("createStudent()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			int res = studentDao.insertStudent(student);
			sqlSession.commit();
			return res;
		}
	}
	
	public int createEnumStudent(Student student) {
		log.debug("createEnumStudent()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			int res = studentDao.insertEnumStudent(student);
			sqlSession.commit();
			return res;
		}
	}
	
	public int updateStudent(Student student) {
		log.debug("updateStudent()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			int res = studentDao.updateStudent(student);
			sqlSession.commit();
			return res;
		}
	}
	
	public int deleteStudent(int studId) {
		log.debug("updateStudent()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			int res = studentDao.deleteStudent(studId);
			sqlSession.commit();
			return res;
		}
	}
	
	public List<Student> selectStudentByAllForResultMap(){
		log.debug("selectStudentByAllForResultMap()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAllForResultMap();
		}
	}
	
	public List<Map<String, Object>> selectStudentByAllForHashMap(){
		log.debug("selectStudentByAllForHashMap()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAllForHashMap();
		}
	}

	public Student selectStudentByForResultMapExtends(Student student) {
		log.debug("selectStudentByForResultMapExtends()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByForResultMapExtends(student);
		}
	}
	
	public Student selectStudentByNoAssociation(Student student) {
		log.debug("selectStudentByForResultMapExtends()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNoAssociation(student);
		}
	}
	
	public Student selectAllStudentByParam(String name, String email) {
		log.debug("selectAllStudentByParam()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectAllStudentByParam(name, email);
		}
	}
	
	public Student selectAllStudentByStudent(Student student) {
		log.debug("selectAllStudentByStudent()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectAllStudentByStudent(student);
		}
	}
	
	public Student selectAllStudentByMap(Map<String, String> map) {
		log.debug("selectAllStudentByMap()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectAllStudentByMap(map);
		}
	}
}
