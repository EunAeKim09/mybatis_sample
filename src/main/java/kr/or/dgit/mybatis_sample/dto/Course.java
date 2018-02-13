package kr.or.dgit.mybatis_sample.dto;

import java.util.Date;

public class Course {
	private int corse_id;
	private String name;
	private String description;
	private Date start_date;
	private Date end_date;
	private int tutor_id;
	public int getCorse_id() {
		return corse_id;
	}
	public void setCorse_id(int corse_id) {
		this.corse_id = corse_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getTutor_id() {
		return tutor_id;
	}
	public void setTutor_id(int tutor_id) {
		this.tutor_id = tutor_id;
	}
	@Override
	public String toString() {
		return String.format("Course [%s, %s, %s, %s, %s, %s]",
				corse_id, name, description, start_date, end_date, tutor_id);
	}
	
	
}
