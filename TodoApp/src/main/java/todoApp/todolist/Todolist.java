package todoApp.todolist;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import todoApp.enduser.Enduser;

@Entity
public class Todolist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Date createDate;
	private String isComplete;
	@ManyToOne
	private Enduser enduser;

	public Todolist() {
		
	}


	public Todolist(Long id, String name, Date createDate, String isComplete) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
		this.isComplete = isComplete;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getIsComplete() {
		return isComplete;
	}


	public void setIsComplete(String isComplete) {
		this.isComplete = isComplete;
	}


	public Enduser getEnduser() {
		return enduser;
	}


	public void setEnduser(Enduser enduser) {
		this.enduser = enduser;
	}
	
}
