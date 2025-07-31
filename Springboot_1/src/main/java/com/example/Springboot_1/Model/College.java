package com.example.Springboot_1.Model;
import jakarta.persistence.*;

@Entity
@Table(name="college")

public class College {
	
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
@Column(name="name")
	private String name;
@Column(name="dept")
	private String dept;
@Column(name="status")
    private boolean status;

public College() 
{

}

public College(String name, String dept, boolean status)
{
	this.name = name;
	this.dept = dept;
	this.status = status;	
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDept() {
	return dept;
}

public void setDept(String dept) {
	this.dept = dept;
}

public boolean isStatus() {
	return status;
}

public void setStatus(boolean status) {
	this.status = status;
}


@Override
public String toString()
{
	return "College [id=" + id + ", name= "+ name+ " dept=" + dept + ", status=" + status + "]";
}
	
	
}
