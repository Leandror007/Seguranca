package seguranca.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="TB_SISTEMA")
public class Sistema implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_SISTEMA")
	private Integer codigo;
	
	@Size(min=5,message="Nome do sistema precisa ter pelo menos 5 caracteres")
	@NotNull(message="O campo nome é obrigatório")
	@Column(name="NM_SISTEMA",nullable=false,length=100)
	private String nome;
	
	
	@Size(min=10,message="Nome da URL precisa ter pelo menos 10 caracteres")
	@NotNull(message="O campo nome é obrigatório")
	@Column(name="DS_URL",length=255,nullable=false)
	private String url;
	
	@OneToMany(mappedBy="sistema")
	private List<Role> roles;

	public Sistema() {
		super();
	}

	@XmlTransient
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@XmlTransient
	public List<Role> getRoles() {
		return roles;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sistema other = (Sistema) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	

}
