package hibernate1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Profesor")

public class Profesor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="IdProfesor")
	@Id
	private int id;
	@Column(name="NombreProfesor")
	private String nombre;
	@Column(name="SexoProfesor")
	private String sexo;
	
	public Profesor() {
		
	}
	
	public Profesor(int id, String nombre, String sexo) {
		this.setId(id);
		this.setNombre(nombre);
		this.setSexo(sexo);
	}
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
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo=sexo;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", sexo=" + sexo + "]";
	}
	

}
