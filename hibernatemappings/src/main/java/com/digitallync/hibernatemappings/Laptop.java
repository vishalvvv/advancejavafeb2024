package com.digitallync.hibernatemappings;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Laptop {
	@Id
	private int lid;
	private String lname;
	
 	@ManyToMany // (mappedBy = "laptop")
	// @ManyToOne
	// private Student student; 
	 private List<Student> student = new ArrayList<Student>();
	
   // @OneToOne(mappedBy = "laptop")
  //  private Student student; 
    
    
    

	
	
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	public int getLid() {
		return lid;
	}
 //	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
	//	this.student = student;
	// }
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	 public List<Student> getStudent() {
		return student;
	 }
	  public void setStudent(List<Student> student) {
		this.student = student;
	 }

}
