package dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mointor database table.
 * 
 */
@Entity
@NamedQuery(name="Mointor.findAll", query="SELECT m FROM Mointor m")
public class Mointor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String email;

	@Lob
	private String facebook;

	@Column(name="home_phone")
	private String homePhone;

	private String mobile;

	private String name;

	@Column(name="org_id")
	private int orgId;

	private String postion;

	@Lob
	private String twitter;

	//bi-directional many-to-one association to StMo
	@OneToMany(mappedBy="mointor")
	private List<StMo> stMos;

	public Mointor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
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

	public int getOrgId() {
		return this.orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getPostion() {
		return this.postion;
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}

	public String getTwitter() {
		return this.twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public List<StMo> getStMos() {
		return this.stMos;
	}

	public void setStMos(List<StMo> stMos) {
		this.stMos = stMos;
	}

	public StMo addStMo(StMo stMo) {
		getStMos().add(stMo);
		stMo.setMointor(this);

		return stMo;
	}

	public StMo removeStMo(StMo stMo) {
		getStMos().remove(stMo);
		stMo.setMointor(null);

		return stMo;
	}

}