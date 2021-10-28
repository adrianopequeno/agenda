package model;

import java.util.Objects;

public class JavaBeans {
	
	private Integer idcon;
	private String nome;
	private String fone;
	private String email;
	
	public JavaBeans() {
		
	}

	public JavaBeans(Integer idcon, String nome, String fone, String email) {
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdcon() {
		return idcon;
	}

	public void setIdcon(Integer idcon) {
		this.idcon = idcon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idcon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JavaBeans other = (JavaBeans) obj;
		return Objects.equals(idcon, other.idcon);
	}
	
	

}
