package kr.or.dgit.mybatis_sample.dao;

import java.util.List;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	//select
	Student selectStudentByNoWidthAPI(Student student);
	List<Student> selectStudentByAllWidthAPI();
	//insert
	int insertStudentWidthAPI(Student student);
}
