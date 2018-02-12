package kr.or.dgit.mybatis_sample.dao;

import java.util.List;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
<<<<<<< HEAD
	Student selectStudentByNo(Student student);
	
	List<Student> selectStudentByAll();
	
	int insertStudent(Student student);
	
	int updateStudent(Student student);
	
	int deleteStudent(int id);
=======
	//select
	Student selectStudentByNoWidthAPI(Student student);
	List<Student> selectStudentByAllWidthAPI();
	//insert
	int insertStudentWidthAPI(Student student);
	//update
	int updateStudnetWithAPI(Student student);
	//delete
	int deleteStudentWithAPI(int id);
	

	List<Student> selectStudentByAllForResultMap();
	List<Student> selectStudentByAllForResultMapWithApi();
>>>>>>> refs/heads/hotfix_mapResult
}
