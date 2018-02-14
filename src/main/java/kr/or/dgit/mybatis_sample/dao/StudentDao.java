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
	
	Student selectAllStudentByParamWithAPI(String name, String email);
	Student selectAllStudentByStudentWithAPI(Student student);
	Student selectAllStudentByMapWithAPI(Map<String, String> map);
	
	//insert
	int insertStudentWidthAPI(Student student);
	int insertEnumStudentWithAPI(Student student);
	//update
	int updateStudnetWithAPI(Student student);
	//delete
	int deleteStudentWithAPI(int id);
	
	//ResultSet 처리방식의 재정의
	Map<Integer, String> selectStudentForMapWithAPI();
}
