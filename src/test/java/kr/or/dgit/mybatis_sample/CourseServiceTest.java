package kr.or.dgit.mybatis_sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.Course;
import kr.or.dgit.mybatis_sample.service.CourseService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseServiceTest {
	private static CourseService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new CourseService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1SelectCoursesByConditionWithAPI() {
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<>();
		map.put("tutor_id", 1);
		map.put("name", "%java%");
		map.put("start_date", cal.getTime());

		List<Course> courses = service.selectCoursesByConditionWithAPI(map);
		Assert.assertNotNull(courses);

		for (Course cour : courses) {
			System.out.println(cour);
		}

	}

	@Test
	public void test2selectCaseCoursesWithAPI() {
		Map<String, Object> map = new HashMap<>();
		map.put("searchBy", "Tutor");
		map.put("tutor_id", 1);

		List<Course> courses = service.selectCaseCoursesWithAPI(map);
		Assert.assertNotNull(courses);

		for (Course cour : courses) {
			System.out.println(cour);
		}

		map.replace("searchBy", "CourseName");
		map.remove("tutor_id");
		map.put("name", "%java%");
		courses = service.selectCaseCoursesWithAPI(map);
		Assert.assertNotNull(courses);

		for (Course cour : courses) {
			System.out.println(cour);
		}
	}
	
	@Test
	public void test3selectWhereCoursesWithAPI() {
		Map<String, Object> map = new HashMap<>();
		
		List<Course> courses = service.selectWhereCoursesWithAPI(map);
		Assert.assertNotNull(courses);
		
		map.put("tutor_id", 1);
		courses = service.selectWhereCoursesWithAPI(map);
		Assert.assertNotNull(courses);
		
		map.put("name", "%java%");
		courses = service.selectWhereCoursesWithAPI(map);
		
		map.clear();
		map.put("end_date", new Date());
		courses = service.selectWhereCoursesWithAPI(map);
		
	}
	
	@Test
	public void test4SelectTrimCoursesWithAPI() {
		Map<String, Object> map = new HashMap<>();
		List<Course> courses = service.selectTrimCoursesWithAPI(map);
		Assert.assertNotNull(courses);
		
		map.put("tutor_id", 1);
		courses = service.selectTrimCoursesWithAPI(map);
		Assert.assertNotNull(courses);
		
		map.put("tutor_id", 1);
		map.put("name", "%java%");
		courses = service.selectTrimCoursesWithAPI(map);
		Assert.assertNotNull(courses);		
	}
	
	@Test
	public void test5SelectCoursesForeachByTutorsWithAPI() {
		List<Integer> tutorIds = new ArrayList<>();
		tutorIds.add(1);
		tutorIds.add(2);
		
		Map<String, Object> map = new HashMap<>();
		map.put("tutorIds", tutorIds);
		
		List<Course> courses = service.selectCoursesForeachByTutorsWithAPI(map);
		Assert.assertNotNull(courses);
	}

}
