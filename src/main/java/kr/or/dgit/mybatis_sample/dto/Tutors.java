package kr.or.dgit.mybatis_sample.dto;

import java.util.List;

public class Tutors {
	private int tutor_id;
	private String name;
	private String email;
	private Address address;
	private List<Course> courses;
	public int getTutor_id() {
		return tutor_id;
	}
	public void setTutor_id(int tutor_id) {
		this.tutor_id = tutor_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return String.format("Tutors [%s, %s, %s, %s, %s]", 
				tutor_id, name, email, address, courses);
	}
	
	
}
