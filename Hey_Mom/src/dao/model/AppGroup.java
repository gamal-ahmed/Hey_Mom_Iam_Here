package dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the app_group database table.
 * 
 */
@Entity
@Table(name="app_group")
@NamedQuery(name="AppGroup.findAll", query="SELECT a FROM AppGroup a")
public class AppGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	@Column(name="role_id")
	private int roleId;

	//bi-directional many-to-one association to AppGroupRole
	@OneToMany(mappedBy="appGroup")
	private List<AppGroupRole> appGroupRoles;

	public AppGroup() {
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

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public List<AppGroupRole> getAppGroupRoles() {
		return this.appGroupRoles;
	}

	public void setAppGroupRoles(List<AppGroupRole> appGroupRoles) {
		this.appGroupRoles = appGroupRoles;
	}

	public AppGroupRole addAppGroupRole(AppGroupRole appGroupRole) {
		getAppGroupRoles().add(appGroupRole);
		appGroupRole.setAppGroup(this);

		return appGroupRole;
	}

	public AppGroupRole removeAppGroupRole(AppGroupRole appGroupRole) {
		getAppGroupRoles().remove(appGroupRole);
		appGroupRole.setAppGroup(null);

		return appGroupRole;
	}

}