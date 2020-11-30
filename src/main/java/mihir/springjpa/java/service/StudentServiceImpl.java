package mihir.springjpa.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mihir.springjpa.java.entity.Student;
import mihir.springjpa.java.dao.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student findByID(Long id) {
		
		  Optional<Student> result = studentRepository.findById(id);
		  
		  Student student;
		if (result.isPresent())
			  student = result.get();
		else 
			throw new RuntimeException("Did Not Found Student By ID : "+ id);
		
		
		return student;
	}

	@Override
	public void save(Student theStudent) {
		studentRepository.save(theStudent);
		
	}

	@Override
	public void deleteByID(Long Id) {
		
		studentRepository.deleteById(Id);
		
	}

}
