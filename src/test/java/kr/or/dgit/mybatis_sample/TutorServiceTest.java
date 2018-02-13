package kr.or.dgit.mybatis_sample;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.Tutor;
import kr.or.dgit.mybatis_sample.service.TutorService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorServiceTest {
	private static TutorService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new TutorService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1SelectTutorByTutorIdWithAPI() {
		Tutor tutor = new Tutor();
		tutor.setTutorId(1);
		
		Tutor findTutor = service.selectTutorByTutorIdWithAPI(tutor);
		Assert.assertEquals(tutor.getTutorId(), findTutor.getTutorId());
		
		System.out.println(findTutor);
	}

}
