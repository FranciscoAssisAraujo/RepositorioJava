package br.com.condominio.application;

import org.hibernate.HibernateException;

import br.com.condominio.DB.Persistencia;
import br.com.condominio.condominioPO.CondominioPO;

public class MainTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persistencia pt = new Persistencia();
		
		CondominioPO cvo = new CondominioPO();
	//	long x = 1;
	//	cvo.setId(x);
		cvo.setCnpj("123.234.654-88");
		cvo.setConselheirofiscal("Sandra");
	cvo.setEndereco("Rua Itapemirim, 463");
	cvo.setNome("Condominio Santo Antonio");
	cvo.setSubsindico("Leonardo Evangelista de Araujo");
		cvo.setUnidades(6);
		
		pt.Save(cvo);
		
	//	pt.Delete(cvo);
		
//		cvo = (CondominioVO) pt.GetObj(cvo, cvo.getId());
//			System.out.println(cvo.getNome());
		
	}
 
}
