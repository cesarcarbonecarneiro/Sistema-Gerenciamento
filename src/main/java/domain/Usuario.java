package domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize.ISO;



@Entity
@Table(name="usuario")
@PrimaryKeyJoinColumn(name = "id_pessoa", referencedColumnName = "id")
public class Usuario extends AbstractPessoa {
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="prfil_id_fk")
	private List<Perfil> perfil;
	@OneToOne
	@JoinColumn(name="cargo_id_fk")
	private Cargo cargo;

	@Column(name="data_entrada",nullable=false,columnDefinition="DATE")
	private LocalDate data_aniversario;
	
	public List<Perfil> getPerfil() {
		return perfil;
	}
	public void setPerfil(List<Perfil> perfil) {
		this.perfil = perfil;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
}
