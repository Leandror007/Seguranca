package seguranca.model.dao;

import java.util.List;

import seguranca.model.domain.Sistema;

public interface SistemaDao {

	List<Sistema> getSistemas();
	public void excluir(Sistema sistema);
	Sistema salvar(Sistema sistema);
	void atualizar(Sistema sistema);
	List<Sistema> getSistemas(Sistema sistema);


}
