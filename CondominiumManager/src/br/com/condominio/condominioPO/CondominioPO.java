package br.com.condominio.condominioVO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="condominio")
public class CondominioVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="nome")
	String nome;	
	@Column(name="cnpj")
	String cnpj;
	@Column(name="endereco")
	String endereco;	
	@Column(name="unidades")
	Integer unidades;	
	@Column(name="sindico")
	String sindico;	
	@Column(name="subsindico")
	String subsindico;	
	@Column(name="Conselheirofiscal")
	String conselheirofiscal;
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
	public int getId() {
		return id;
	}	
}


/*
 * @Entity
@Table(name="agenda")
public class AgendaVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="atividade")
	String atividade;	
	Date date;
}
*/