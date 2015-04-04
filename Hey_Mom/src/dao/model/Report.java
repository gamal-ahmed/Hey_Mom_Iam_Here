package dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the report database table.
 * 
 */
@Entity
@NamedQuery(name="Report.findAll", query="SELECT r FROM Report r")
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to StMo
	@ManyToOne
	@JoinColumn(name="st_mon_id")
	private StMo stMo;

	//bi-directional many-to-one association to ReportType
	@ManyToOne
	@JoinColumn(name="type_id")
	private ReportType reportType;

	public Report() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StMo getStMo() {
		return this.stMo;
	}

	public void setStMo(StMo stMo) {
		this.stMo = stMo;
	}

	public ReportType getReportType() {
		return this.reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}

}