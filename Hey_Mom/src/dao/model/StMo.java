package dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the st_mo database table.
 * 
 */
@Entity
@Table(name="st_mo")
@NamedQuery(name="StMo.findAll", query="SELECT s FROM StMo s")
public class StMo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="stMo")
	private List<Report> reports;

	//bi-directional many-to-one association to Mointor
	@ManyToOne
	@JoinColumn(name="mo_id")
	private Mointor mointor;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="st_id")
	private Student student;

	public StMo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Report> getReports() {
		return this.reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Report addReport(Report report) {
		getReports().add(report);
		report.setStMo(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setStMo(null);

		return report;
	}

	public Mointor getMointor() {
		return this.mointor;
	}

	public void setMointor(Mointor mointor) {
		this.mointor = mointor;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}