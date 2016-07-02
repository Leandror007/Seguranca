package seguranca.model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import seguranca.model.dao.SistemaDao;
import seguranca.model.domain.Sistema;
import seguranca.model.facade.SistemaFacade;

@WebService(serviceName="ws/sistema")
public class SistemaFacadeImpl implements SistemaFacade {
	
	@Inject
	private SistemaDao sistemaDao;
			
	@WebMethod
	public List<Sistema> getSistemas() {
		return sistemaDao.getSistemas(new Sistema());
	}
	
	@Override
	@WebMethod(operationName="getSistemaCodigo")
	public List<Sistema> getSistemas(@WebParam(name="codigoSistema") 
							Integer codigo) {
		Sistema sistema = new Sistema();
		sistema.setCodigo(codigo);
		return sistemaDao.getSistemas(sistema);
	}
	
	@WebMethod
	public Sistema salvar(@WebParam(name="sistema") Sistema sistema) {
		return sistemaDao.salvar(sistema);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="sistema") Sistema sistema) {
		sistemaDao.atualizar(sistema);
	}
	
	@WebMethod
	public void deletarSistema(@WebParam(name="codigoSistema") Integer codigo) {
		Sistema sistema = new Sistema();
		sistema.setCodigo(codigo);
		sistemaDao.excluir(sistema);
	}


}
