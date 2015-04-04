package dao.model;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	private int age;

	@Lob
	private String avatar;

	private String email;

	@Column(name="group_id")
	private int groupId;

	@Column(name="home_phone")
	private String homePhone;

	private String mobile;

	private String name;

	//bi-directional many-to-one association to AccSt
	@OneToMany(mappedBy="account")
	private List<AccSt> accSts;

	public Account() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
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
		accSt.setAccount(this);

		return accSt;
	}

	public AccSt removeAccSt(AccSt accSt) {
		getAccSts().remove(accSt);
		accSt.setAccount(null);

		return accSt;
	}

}