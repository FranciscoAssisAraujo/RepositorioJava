package br.com.condominio.condominioPO;

public class CondominioPO {	
	private Long id;	
	private String nome;		
	private String cnpj;	
	private String endereco;		
	private Integer unidades;		
	private String sindico;		
	private String subsindico;		
	private String conselheirofiscal;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getUnidades() {
		return unidades;
	}
	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}
	public String getSindico() {
		return sindico;
	}
	public void setSindico(String sindico) {
		this.sindico = sindico;
	}
	public String getSubsindico() {
		return subsindico;
	}
	public void setSubsindico(String subsindico) {
		this.subsindico = subsindico;
	}
	public String getConselheirofiscal() {
		return conselheirofiscal;
	}
	public void setConselheirofiscal(String conselheirofiscal) {
		this.conselheirofiscal = conselheirofiscal;
	}
	
	
}


