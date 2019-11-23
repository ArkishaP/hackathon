package com.hackathon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.hackathon.model.Report;

@Repository("reportDao")
public class ReportDaoImpl implements ReportDao{
	 public List<Object[]> getReport(String studentId){
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		  EntityManager em = emf.createEntityManager();	  
			//String sql="SELECT st.studentId,st.first_name,su.subjectName,su.difficulty,r.id,r.score,e.examId FROM Student st,Subject su,Report r,Exam e  where st.studentId=e.studentId and su.subjectId=e.subjectId and e.examId=r.examId "  ;
			 @SuppressWarnings("unchecked")
			 String sql="SELECT st.id sid,st.first_name,su.name,su.difficulty,r.id scoreid,r.score,e.id examid FROM Student st,Subject su,score r,Exam e  where st.id=e.student_id and su.id=e.subject_id and e.id=r.exam_id and st.id=:id1";

	//			List<Object[]> result = em.createNativeQuery("SELECT st.id,st.first_name,su.name,su.difficulty,r.id,r.score,e.id FROM Student st,Subject su,score r,Exam e  where st.id=e.student_id and su.id=e.subject_id and e.id=r.exam_id" ).getResultList();

			 List<Object[]> result = em.createNativeQuery(sql).setParameter("id1", studentId).getResultList();      
			for( Object[] i: result)
			{
			    System.out.println(i[0]);
			    System.out.println(i[1]);
			    System.out.println(i[2]);
			    System.out.println(i[3]);
			    System.out.println(i[4]);
			    System.out.println(i[5]);
			    System.out.println(i[6]);
			    
			}
			return result;
		  }

		public List<Object[]> searchStudent(String subjectName,String difficulty,int score){
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			  EntityManager em = emf.createEntityManager();	
			  @SuppressWarnings("unchecked")
			  String sql="SELECT * FROM Student st,Subject su,Exam e,Score r where st.id=e.student_id and su.id=e.subject_id and e.id=r.exam_id  and su.subject_name=:subName and su.difficulty=:level and r.score=:score" ;
				 List<Object[]> search= em.createNativeQuery(sql).setParameter("subName", subjectName).setParameter("level", difficulty).setParameter("score", score).getResultList(); 

					return search;
		}

}
