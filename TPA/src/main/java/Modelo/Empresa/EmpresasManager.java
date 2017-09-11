package Modelo.Empresa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.security.auth.login.Configuration;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import Excepciones.Empresas.NoExisteLaEmpresaException;

public class EmpresasManager extends BolsaDeEmpresas implements WithGlobalEntityManager {
	
private static BolsaDeEmpresas bolsa = null;
	
	private List<Empresa> empresas = new ArrayList<Empresa>();
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresasNuevas) {
		empresas = empresasNuevas;
	}

	public Empresa buscarEmpresa(String unNombre) {
		return bolsa.getEmpresas().stream().filter( e -> e.getNombre().equals(unNombre)).findFirst().orElseThrow(() -> new NoExisteLaEmpresaException());
	}
	
	public List<String> getNombresDeEmpresas() {
		return bolsa.getEmpresas().stream().map((Empresa e) -> e.getNombre()).collect(Collectors.toList());		
	}
	
    public static BolsaDeEmpresas getInstancia() {
		
		if(bolsa == null){
			bolsa = new BolsaDeEmpresas();
		}
		
		return bolsa;
	}
		
    public List<String> traerNombresDeEmpresas(){
		return this.entityManager().createQuery("SELECT Empresa_Nombre FROM Empresa" ).getResultList();
    }
    
    
    public Empresa findByName(String nombre){
    	
    	Query q = this.entityManager().createQuery("FROM Empresa e WHERE c.nombre = :nombre");
    	q.setParameter("nombre", nombre);
    	return (Empresa) q.getSingleResult();
    	
    	/* Seguir investigando, hasta la linea 58 funciona
    	CriteriaBuilder constructor = this.entityManager(). getCriteriaBuilder ();
    	CriteriaQuery <Integer> criteria = constructor.createQuery (Integer.class);
    	Root <Periodo> personRoot = criteria.from (Periodo.class);
    	criteria.select (personRoot.get (Person_.age));
    	criteria.where (builder.equal (personRoot.get (Person_.eyeColor), "brown"));
    	Lista <Entero> ages = em.createQuery (criteria) .getResultList ();
    	*/
    
    }
}
