package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CascadeExample 
{
	public static void main(String[] args)
	{
		
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
       Session s=factory.openSession();
       
       Question q1=new Question();
       
       q1.setQuestionId(757);
       q1.setQuestion("what is Swing");
       
       Answer a1=new Answer(423,"Used for Desktop app");
       Answer a2=new Answer(543,"user friendly app");
       Answer a3=new Answer(765,"This can be useful for Designing.");
       
       List<Answer> list=new ArrayList<>();
       list.add(a1);
       list.add(a2);
       list.add(a3);
       
       q1.setAnswers(list);
       Transaction tx=s.beginTransaction();
       s.save(q1);
     //s.save(a1);
     //s.save(a2);
     //s.save(a3);
       
       
       tx.commit();
       s.close();
       factory.close();		
		
	}

}
