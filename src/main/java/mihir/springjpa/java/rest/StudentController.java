package mihir.springjpa.java.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mihir.springjpa.java.entity.Student;
import mihir.springjpa.java.service.StudentService;



@RestController
@RequestMapping("/api")
public class StudentController {
	
	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
	@GetMapping("/students")
	public List<Student> findAll()
	{
		return studentService.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student findByID(@PathVariable Long id)
	{
		return studentService.findByID(id);
	}
	
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student theStudent)
	{
		
		theStudent.setIds(0);
		studentService.save(theStudent);
		
		return theStudent;
		
	}
	
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student theStudent)
	{
		
		
		Student student = studentService.findByID(theStudent.getIds());
		
		if(student == null)
			throw new StudentNotFoundException("Not Able to Find Student by ID: " + theStudent.getIds());
		
		theStudent.setCreateDateTime(student.getCreateDateTime());
		
		studentService.save(theStudent);
		
		return theStudent;
		
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteByID(@PathVariable Long Id)
	{
		
		Student theStudent = studentService.findByID(Id);
		
		if(theStudent == null)
			throw new StudentNotFoundException("Not Able to Find Student by ID: " + Id);
		
		studentService.deleteByID(Id);
		
		return ("Deleted Student by ID: " + Id);
		
		
		
	}

	
}
