package dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the report_type database table.
 * 
 */
@Entity
@Table(name="report_type")
@NamedQuery(name="ReportType.findAll", query="SELECT r FROM ReportType r")
public class ReportType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="reportType")
	private List<Report> reports;

	public ReportType() {
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

	public List<Report> getReports() {
		return this.reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Report addReport(Report report) {
		getReports().add(report);
		report.setReportType(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setReportType(null);

		return report;
	}

}