package br.com.alura.loja.testes;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProdutos {
	
	public static void main(String[] args) {
		
		Produto celular = new Produto();
		celular.setNome("Asus Zenfone");
		celular.setDescricao("Camera com alta definição");
		celular.setPreco(new BigDecimal("1600"));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new br.com.alura.loja.dao.ProdutoDao(em);
		
		em.getTransaction().begin();
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
		
	}
}

