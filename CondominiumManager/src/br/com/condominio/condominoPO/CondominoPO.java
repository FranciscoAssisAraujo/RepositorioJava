package br.com.condominio.condominoPO;

import java.util.HashSet;
import java.util.Set;

import br.com.condominio.unidadePO.UnidadePO;

public class CondominoPO {
	private Long id;	
	private String nome;			
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
	public Set<UnidadePO> getUnidadepo() {
		return unidadepo;
	}
	public void setUnidadepo(Set<UnidadePO> unidadepo) {
		this.unidadepo = unidadepo;
	}
	

}
