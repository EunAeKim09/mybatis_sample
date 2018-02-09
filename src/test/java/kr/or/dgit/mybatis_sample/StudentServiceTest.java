package kr.or.dgit.mybatis_sample;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.PhoneNumber;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.service.StudentService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	
	@Test
	public void test3insertStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		
		Student student = 
				new Student(3, "홍길동3", "lee@test.co.kr", newDate.getTime(), new PhoneNumber("010-1234-1234"));
		int res = service.insertStudent(student);
		Assert.assertEquals(1, res);
	}
}
