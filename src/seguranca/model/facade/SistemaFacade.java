package seguranca.model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import seguranca.model.domain.Sistema;

public interface SistemaFacade {
	List<Sistema> getSistemas();

	List<Sistema> getSistemas(Integer codigo);

	@ValidateOnExecution
	Sistema salvar(@Valid Sistema sistema);

	void atualizar(Sistema sistema);

	void deletarSistema(Integer codigo);

}
