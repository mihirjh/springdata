package mihir.springjpa.java.service;

import java.util.List;

import mihir.springjpa.java.entity.*;

public interface StudentService {
	
	public List<Student> findAll();
	
	public Student findByID(Long id);
	
	public void save(Student theStudent);
	
	public void deleteByID(Long Id);

}
