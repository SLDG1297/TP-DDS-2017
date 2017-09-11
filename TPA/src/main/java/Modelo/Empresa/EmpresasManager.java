package Modelo.Empresa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import DB.DBManager;

public class EmpresasManager /*implements WithGlobalEntityManager*/ extends DBManager {
	
	private static EmpresasManager bolsa = null;
	
	public List<Empresa> getEmpresas() {
		return (List<Empresa>) entityManager().createQuery("FROM Empresa" ).getResultList();
	}

	public void insertarListaDeEmpresas(List<Empresa> empresas) {
	  	beginTransaction();
	  	/*EntityManager em = PerThreadEntityManagers.getEntityManager();
		EntityManager em = this.entityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();*/
    	for (Empresa e : empresas){
    		persist(e);
    		//em.persist(e);
    	}
    	commit();
    	//tx.commit();
	}

	public Empresa buscarEmpresa(String nombre) {
		return (Empresa) entityManager().createQuery("FROM Empresa e WHERE c.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
	}
	
	public List<String> getNombresDeEmpresas() {
		return (List<String>) entityManager().createQuery("SELECT Empresa_Nombre FROM Empresa" ).getResultList();	
	}
	
    public static EmpresasManager getInstancia() {
		
		if(bolsa == null){
			bolsa = new EmpresasManager();
		}
		
		return bolsa;
	}
}
