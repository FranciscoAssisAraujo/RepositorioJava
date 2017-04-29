package br.com.condominio.DB;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;

import br.com.condominio.condominioPO.CondominioPO;

public class Persistencia {

	Session session = HibernateUtil.getSessionFactory().openSession();
 
	Transaction transaction = null;

	public  void Save(Object obj) {
		try {
			transaction = session.beginTransaction();
			session.save(obj);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	
	public void Delete(Object obj) {
		try {
			transaction = session.beginTransaction();
			session.delete(obj);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			System.out.println("Registro Excluido!!!!");
			session.close();
		}

	}

	public void Update(Object obj) {
		try {
			transaction = session.beginTransaction();
			session.update(obj);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	
	public Object GetObj(Object obj, Long id) {
		 return session.load(obj.getClass(), id);		
	}
	
//	public ArrayList<CondominioPO> GetListCondominio(){
//		return (List) session.createQuery("select * from tb_condominiopo").list();
//	}

	
	 public ArrayList<CondominioPO> getlistaCondominios() {     
	        ArrayList<CondominioPO> listaCondominios = new ArrayList<>(session.createCriteria(CondominioPO.class).list());
	        for(CondominioPO p : listaCondominios){
	            session.refresh(p);
	        }
	        return listaCondominios;
	   }
	

}
