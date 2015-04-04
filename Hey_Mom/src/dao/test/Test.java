package dao.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.model.Account;



public class Test {
	 private EntityManager manager;
	 
	    public Test(EntityManager manager) {
	        this.manager = manager;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
	        EntityManager manager = factory.createEntityManager();
	        Test test = new Test(manager);
	 
	        EntityTransaction tx = manager.getTransaction();
	        tx.begin();
	        try {
	            test.createaccounts();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        tx.commit();
	 
	        test.listaccounts();
	 
	        System.out.println(".. done");
	}
	 private void createaccounts() {
		Account ok= new Account();
		ok.setName("gemi");
//		
         manager.persist(ok);
	    }
	 
	    private void listaccounts() {
	      
	    }

}
