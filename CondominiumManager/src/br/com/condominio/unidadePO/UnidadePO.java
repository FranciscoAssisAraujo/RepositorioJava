package br.com.condominio.unidadePO;

import br.com.condominio.blocoPO.BlocoPO;
import br.com.condominio.condominoPO.CondominoPO;

public class UnidadePO {
	private Long id;	
	private BlocoPO bloco;	
	private String andar;	
	private String apartamento;		
	private CondominoPO condomino;
	
	public BlocoPO getBloco() {
		return bloco;
	}
	public void setBloco(BlocoPO bloco) {
		this.bloco = bloco;
	}
	public String getAndar() {
		return andar;
	}
	public void setAndar(String andar) {
		this.andar = andar;
	}
	public String getApartamento() {
		return apartamento;
	}
	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}
	public CondominoPO getCondomino() {
		return condomino;
	}
	public void setCondomino(CondominoPO condomino) {
		this.condomino = condomino;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
