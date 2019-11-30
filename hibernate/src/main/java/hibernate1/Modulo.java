package hibernate1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Modulo")
public class Modulo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="IdModulo")
	@Id
	private int id;
	@Column(name="NombreModulo")
	private String nombre;
	@Column(name="CodigoModulo")
	private int codigo;
	
	public Modulo() {
		
	}
	
	public Modulo(int id, String nombre, int codigo) {
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return "Modulo [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}


	public static void main(String[] args) {
		

	}

}
