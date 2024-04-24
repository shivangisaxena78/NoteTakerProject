package hqlExample;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;

//import javax.persistence.Query;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Student;

public class HQLExample {

	public static void main(String[] args)
	{
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
       Session s=factory.openSession();
       //HQL
        
        String query="from Student as s where s.city=:x and s.name=:n";
        Query q=s.createQuery(query);
        q.setParameter("x", "Bhopal");
        q.setParameter("n", "Vinay");
        
        //single-(Uniqe)
        //multiple-list
        
        List<Student> list=q.list();
        
        for(Student student:list)
        {
        	System.out.println(student.getName());       
        	
        }
        System.out.println("_______________________________________");
        Transaction tx=s.beginTransaction();
        
        //delete query
        
       // Query q2=s.createQuery("delete from Student s where city=:c");
        //q2.setParameter("c", "indore");
        //int r=q2.executeUpdate();
        //System.out.println("Deleted:");
        //System.out.println(r);
        
        //update query
        Query q2=s.createQuery("update Student set city=:c where name=:n");
        q2.setParameter("c", "LONDON");
        q2.setParameter("n", "pihu");
        int r=q2.executeUpdate();
        System.out.println(r+"objects updated");
        tx.commit();
        
        //execute join query
        Query q3=s.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answers as a");
        List<Object[]> list3=q3.getResultList();
        for(Object[] arr:list3)
        {
        	System.out.println(Arrays.toString(arr));
        	
        }
        
        s.close();
        
        
        factory.close();

	}

}
