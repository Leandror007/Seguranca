package seguranca.model.dao;

import java.util.List;

import seguranca.model.domain.Sistema;

public interface SistemaDao {

	List<Sistema> getSistemasUsuarioLogado();
	
	List<Sistema> getSistemas();
	
	public void excluir(Sistema sistema);
	
	public Sistema salvar(Sistema sistema);
	
	public void atualizar(Sistema sistema);

}
