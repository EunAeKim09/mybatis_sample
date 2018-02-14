package kr.or.dgit.mybatis_sample.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	//select
	Student selectStudentByNo(Student student);
	List<Student> selectStudentByAll();
	
	List<Student> selectStudentByAllForResultMap();
	List<Map<String, Object>> selectStudentByAllForHashMap();
	
	Student selectStudentByForResultMapExtends(Student student);
	
	Student selectStudentByNoAssociation(Student student);
	
	Student selectAllStudentByParam(String name, String email);
	Student selectAllStudentByStudent(Student student);
	Student selectAllStudentByMap(Map<String, String> map);
	
	//insert
	int insertStudent(Student student);
	int insertEnumStudent(Student student);
	
	//update
	int updateStudent(Student studeent);
	//delete
	int deleteStudent(int studId);
	
}
