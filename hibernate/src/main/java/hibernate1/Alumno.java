package hibernate1;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Para que sea reconocido como entidad, se usa @Entity de javax.persistence
@Entity
//Lo almacenamos en una tabla con el nombre que querramos
@Table(name="Alumno")
public class Alumno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Creamos la columnas y sus id
	@Column(name="IdAlumno")
	@Id
	private int id;
	
	@Column(name = "NombreAlumno")
	private String nombre;
	
	@Column(name = "NacionalidadAlumno")
	private String nacionalidad;
	
	@Column(name = "EdadAlumno")
	private int edad;

	@Column(name = "SexoAlumno")
	private String sexo;
	
	@Column(name = "ModulosAlumno")
	ArrayList <Modulo> ListaModulos = new ArrayList<Modulo>();
	
   public Alumno() {
	   
   }

	//Debemos convertir la clase en un .bin
	//Para ello creamos un constructor
	public Alumno(int id, String nombre, String nacionalidad, int edad, String sexo, ArrayList ListaModulos) {	
		this.setId(id);
		this.setNombre(nombre);
		this.setNacionalidad(nacionalidad);
		this.setEdad(edad);
		this.setSexo(sexo);
		this.setModulo(ListaModulos);
	}

	//Creamos getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setModulo(ArrayList ListaModulos) {
		this.ListaModulos = ListaModulos;
	}
	public ArrayList getModulo() {
		return ListaModulos;
	}

	
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", edad=" + edad
				+ ", sexo=" + sexo + ", Modulo/s=" + ListaModulos + "]";
	}
}
