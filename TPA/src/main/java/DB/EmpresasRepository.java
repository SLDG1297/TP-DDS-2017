package DB;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import Modelo.Empresa.Empresa;

public class EmpresasRepository extends DBManager {
	
	private static EmpresasRepository bolsa = null;
	
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
	
    public static EmpresasRepository getInstancia() {
		
		if(bolsa == null){
			bolsa = new EmpresasRepository();
		}
		
		return bolsa;
	}
}
