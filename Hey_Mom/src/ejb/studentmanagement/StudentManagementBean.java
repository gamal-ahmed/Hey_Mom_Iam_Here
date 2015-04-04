package ejb.studentmanagement;


import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class StudentManagement
 */

@Stateless(name = "CustomerManagement")
@Remote(StudentManagement.class)
public class StudentManagementBean implements StudentManagement {

    /**
     * Default constructor. 
     */
    public StudentManagementBean() {
        // TODO Auto-generated constructor stub
    }

}
