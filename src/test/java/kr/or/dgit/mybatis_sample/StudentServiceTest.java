package kr.or.dgit.mybatis_sample;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.service.StudentService;

public class StudentServiceTest {
	private static StudentService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new StudentService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1FindStudentByNo() {
		Student student = new Student();
		student.setStudId(1);
		
		Student selectStudent = service.findStudentByNo(student);
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}
	
	@Test
	public void test2FindStudentByAll() {
		List<Student> listStd = service.selectStudentByAll();
		Assert.assertNotNull(listStd);
		for(Student std : listStd) {
			System.out.println(std);
		}
	}

}
