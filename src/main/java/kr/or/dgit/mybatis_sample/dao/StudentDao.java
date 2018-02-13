package kr.or.dgit.mybatis_sample.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	//select
	Student selectStudentByNoWidthAPI(Student student);
	List<Student> selectStudentByAllWidthAPI();
	
	List<Student> selectStudentByAllForResultMapWithAPI();
	
	List<Map<String, Object>> selectStudentByAllForHashMapWithAPI();
	
	Student selectStudentByNoForResultExtendsWithAPI(Student student);
	
	Student selectStudentByNoAssociation(Student student);
	
	//insert
	int insertStudentWidthAPI(Student student);
	//update
	int updateStudnetWithAPI(Student student);
	//delete
	int deleteStudentWithAPI(int id);
}
