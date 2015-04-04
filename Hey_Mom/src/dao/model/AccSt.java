package dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the acc_st database table.
 * 
 */
@Entity
@Table(name="acc_st")
@NamedQuery(name="AccSt.findAll", query="SELECT a FROM AccSt a")
public class AccSt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="st_id")
	private Student student;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="acc_id")
	private Account account;

	public AccSt() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}