package net.codejava.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class IMC {
	private Long id;
	private String name;
	private float peso;
	private float altura;
        private float iMC;
	private String fecha;

	public IMC() {
	}

	protected IMC(Long id, String name, float peso, float altura, float iMC, String fecha) {
		super();
		this.id = id;
		this.name = name;
		this.peso = peso;
		this.altura = altura;
		this.iMC = iMC;
                this.fecha = fecha;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
                this.name = name;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getIMC() {
		return iMC;
	}

	public void setIMC(float iMC) {
                this.iMC = iMC;
	}
        
        public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
                LocalDate miFecha = LocalDate.now();
                DateTimeFormatter miFechaF = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String FechaFormat = miFecha.format(miFechaF);
		this.fecha = FechaFormat;
	}

}
