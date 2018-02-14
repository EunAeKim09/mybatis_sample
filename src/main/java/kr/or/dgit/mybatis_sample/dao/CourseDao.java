package kr.or.dgit.mybatis_sample.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.mybatis_sample.dto.Course;

public interface CourseDao {
	List<Course> selectCoursesByConditionWithAPI(Map<String, Object> map);
	List<Course> selectCaseCoursesWithAPI(Map<String, Object> map);
	List<Course> selectWhereCoursesWithAPI(Map<String, Object> map);
	List<Course> selectTrimCoursesWithAPI(Map<String, Object> map);
	List<Course> selectCoursesForeachByTutorsWithAPI(Map<String, Object> map);
	
}
