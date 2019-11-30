package hibernate1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Tests {

	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	public static void main(String[] args) {
		
		//Creamos el gestor de persistencia
		emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
		FileOutputStream fichero = null;
		
		Profesor profesor = new Profesor(2, "Javier", "Masculino");
		ArrayList <Modulo> ListaModulos = new ArrayList <Modulo>();
		Modulo modulo = new Modulo(101, "Acceso a datos",101);
		ListaModulos.add(modulo);
		Alumno alumno = new Alumno(1, "Daniel", "España", 25, "Masculino", ListaModulos);
		Alumno alumna = new Alumno(3, "Andrea", "Alemania", 26, "Femenino", ListaModulos);
		
		try {
			fichero = new FileOutputStream("Datos.txt");
			ObjectOutputStream canal = new ObjectOutputStream (fichero);
			canal.writeObject(alumno);
			canal.writeObject(profesor);
			canal.writeObject(alumna);
			canal.writeObject(modulo);
		}catch(FileNotFoundException ie) {
			ie.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}finally {
			try {
				fichero.close();
			}catch(IOException ie) {
				ie.printStackTrace();
			}
		}
		
		//Abrimos las transacciones
		manager.getTransaction().begin();
		
		//Incluimos el nuevo alumno creado
		manager.persist(alumno);
		manager.persist(profesor);
		manager.persist(alumna);
		manager.persist(modulo);
		
		manager.getTransaction().commit();
		
		imprimirElementos();

	}
	@SuppressWarnings("unchecked")
	private static void imprimirElementos() {
		List <Alumno> alumnos = (List<Alumno>)manager.createQuery("FROM Alumno").getResultList();
		System.out.println("Hay " + alumnos.size() + " alumno/s en el sistema");
		for(Alumno alumno:alumnos) {
			System.out.println(alumno.toString());
		}
		List <Profesor> profesores = (List<Profesor>)manager.createQuery("FROM Profesor").getResultList();
		System.out.println("Hay " + profesores.size() + " profesor/es en el sistema");
		for(Profesor profesor:profesores) {
			System.out.println(profesor.toString());
		}
		List <Modulo> modulos = (List<Modulo>)manager.createQuery("FROM Modulo").getResultList();
		System.out.println("Hay " + modulos.size() + " modulo/s en el sistema");
		for(Modulo modulo:modulos) {
			System.out.println(modulos.toString());
		}
	}

}
