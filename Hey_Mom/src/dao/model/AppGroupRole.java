package dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the app_group_role database table.
 * 
 */
@Entity
@Table(name="app_group_role")
@NamedQuery(name="AppGroupRole.findAll", query="SELECT a FROM AppGroupRole a")
public class AppGroupRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to AppGroup
	@ManyToOne
	@JoinColumn(name="group_id")
	private AppGroup appGroup;

	//bi-directional many-to-one association to AppRole
	@ManyToOne
	@JoinColumn(name="role_id")
	private AppRole appRole;

	public AppGroupRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AppGroup getAppGroup() {
		return this.appGroup;
	}

	public void setAppGroup(AppGroup appGroup) {
		this.appGroup = appGroup;
	}

	public AppRole getAppRole() {
		return this.appRole;
	}

	public void setAppRole(AppRole appRole) {
		this.appRole = appRole;
	}

}