package dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the report_log database table.
 * 
 */
@Entity
@Table(name="report_log")
@NamedQuery(name="ReportLog.findAll", query="SELECT r FROM ReportLog r")
public class ReportLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	public ReportLog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}