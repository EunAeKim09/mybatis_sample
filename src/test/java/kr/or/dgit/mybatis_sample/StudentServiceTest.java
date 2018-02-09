package kr.or.dgit.mybatis_sample;

import java.util.Calendar;
import java.util.Date;
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
	public void test1FindStudentByNoWidthAPI() {
		Student student = new Student();
		student.setStudId(1);
		
		Student selectStudent = service.findStudentByNoWidthAPI(student);
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}
	
	@Test
	public void test2FindStudentByAllWidthAPI() {
		List<Student> listStd = service.selectStudentByAllWidthAPI();
		Assert.assertNotNull(listStd);
		for(Student std : listStd) {
			System.out.println(std);
		}
	}
	
	@Test
	public void test3insertStudentWidthAPI() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 3, 28);
		
		Student student = 
				new Student(3, "홍길동4", "lee@test.co.kr", newDate.getTime(), new PhoneNumber("010-1234-1234"));
		int res = service.insertStudentWidthAPI(student);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test4updateStudnetWithAPI() {
		Student student = new Student();
		student.setStudId(1);
		student.setName("Timothy");
		student.setEmail("test@test.co.kr");
		student.setPhone(new PhoneNumber("987-654-3211"));
		student.setDob(new Date());
		
		int result = StudentService.updateStudnetWithAPI(student);
		Assert.assertSame(1, result);
		
		student.setEmail("timothy@gmail.com");
		student.setPhone(new PhoneNumber("123-123-1234"));
		student.setDob(new GregorianCalendar(1988,04,25).getTime());
		
		result = StudentService.updateStudnetWithAPI(student);
		Assert.assertSame(1, result);
	}
	
	@Test
	public void test5deleteStudentWithApI() {
		int deleteStudent = StudentService.deleteStudentWithApI(3);
		Assert.assertSame(1, deleteStudent);
	}
}
