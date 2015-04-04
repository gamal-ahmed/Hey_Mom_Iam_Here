package dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int age;

	@Lob
	private String avatar;

	@Column(name="home_phone")
	private String homePhone;

	private String mobile;

	private String name;

	//bi-directional many-to-one association to AccSt
	@OneToMany(mappedBy="student")
	private List<AccSt> accSts;

	//bi-directional many-to-one association to StMo
	@OneToMany(mappedBy="student")
	private List<StMo> stMos;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	@JoinColumn(name="org_id")
	private Organization organization;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AccSt> getAccSts() {
		return this.accSts;
	}

	public void setAccSts(List<AccSt> accSts) {
		this.accSts = accSts;
	}

	public AccSt addAccSt(AccSt accSt) {
		getAccSts().add(accSt);
		accSt.setStudent(this);

		return accSt;
	}

	public AccSt removeAccSt(AccSt accSt) {
		getAccSts().remove(accSt);
		accSt.setStudent(null);

		return accSt;
	}

	public List<StMo> getStMos() {
		return this.stMos;
	}

	public void setStMos(List<StMo> stMos) {
		this.stMos = stMos;
	}

	public StMo addStMo(StMo stMo) {
		getStMos().add(stMo);
		stMo.setStudent(this);

		return stMo;
	}

	public StMo removeStMo(StMo stMo) {
		getStMos().remove(stMo);
		stMo.setStudent(null);

		return stMo;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}