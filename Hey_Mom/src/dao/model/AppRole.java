package dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the app_role database table.
 * 
 */
@Entity
@Table(name="app_role")
@NamedQuery(name="AppRole.findAll", query="SELECT a FROM AppRole a")
public class AppRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to AppGroupRole
	@OneToMany(mappedBy="appRole")
	private List<AppGroupRole> appGroupRoles;

	public AppRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AppGroupRole> getAppGroupRoles() {
		return this.appGroupRoles;
	}

	public void setAppGroupRoles(List<AppGroupRole> appGroupRoles) {
		this.appGroupRoles = appGroupRoles;
	}

	public AppGroupRole addAppGroupRole(AppGroupRole appGroupRole) {
		getAppGroupRoles().add(appGroupRole);
		appGroupRole.setAppRole(this);

		return appGroupRole;
	}

	public AppGroupRole removeAppGroupRole(AppGroupRole appGroupRole) {
		getAppGroupRoles().remove(appGroupRole);
		appGroupRole.setAppRole(null);

		return appGroupRole;
	}

}