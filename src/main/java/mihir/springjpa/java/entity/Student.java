package mihir.springjpa.java.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long ids;
	
	@Column(name="name")
	private String name;
	
	@Column(name="std")
	private String std;
	
	@Column(name="age")
	private String age;
	
	@Column(name="address")
	private String address;
	
	@Column(name="created_on")
	@CreatedDate
	private LocalDateTime createDateTime;
	
	@Column(name="last_login")
	@LastModifiedDate
	private LocalDateTime updateDateTime;
	
	@PrePersist
	protected void onCreate() {
		createDateTime =  LocalDateTime.now();
				
	}
	
	@PreUpdate
	protected void onUpdate() {
		updateDateTime =  LocalDateTime.now();
				
	}
	
	public Student () {}
	
	public Student (Student student) {
		
		super();
		this.name = student.name;
		this.std = student.std;
		this.age = student.age;
		this.address = student.address;
		this.ids = student.ids;
	}

	/**
	 * @param name
	 * @param std
	 * @param age
	 * @param address
	 */
	public Student(String name, String std, String age, String address, long ids) {
		super();
		this.name = name;
		this.std = std;
		this.age = age;
		this.address = address;
		this.ids = ids;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getIds() {
		return ids;
	}

	public void setIds(long ids) {
		this.ids = ids;
	}

	
	
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	@Override
	public String toString() {
		return "Student [id=" + ids + ", Name=" + name + ", Std=" + std + ", age=" + age + "]";
	}
	
	
}
