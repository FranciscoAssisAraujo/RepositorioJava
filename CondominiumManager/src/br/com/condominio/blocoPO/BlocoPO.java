package br.com.condominio.blocoPO;

import java.util.HashSet;
import java.util.Set;

import br.com.condominio.condominioPO.CondominioPO;
import br.com.condominio.unidadePO.UnidadePO;

public class BlocoPO {
	private Long id;	
	private String nome;
	private CondominioPO condominio;
	private Set<UnidadePO> unidadepo =
			new HashSet<UnidadePO>(0);
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public CondominioPO getCondominio() {
		return condominio;
	}
	public void setCondominio(CondominioPO condominio) {
		this.condominio = condominio;
	}
	public Set<UnidadePO> getUnidadepo() {
		return unidadepo;
	}
	public void setUnidadepo(Set<UnidadePO> unidadepo) {
		this.unidadepo = unidadepo;
	}
	

}
