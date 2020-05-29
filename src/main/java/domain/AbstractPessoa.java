package domain;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="pessoa")
public abstract class AbstractPessoa {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name="nome",nullable=false,unique=true,length=50)
	private String nome;
	@Column(name="sexo",nullable=false,unique=true,length=1)
	private char sexo;
	@Column(name="cpf",nullable=false,unique=true,length=11)
	private String cpf;
	@Column(name="data_aniversario",nullable=false,columnDefinition="DATE")
	private Date data_aniversario;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getAniversario() {
		return data_aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.data_aniversario = aniversario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "id=" + id;
	}
	
}
