package seguranca.model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import seguranca.model.dao.SistemaDao;
import seguranca.model.domain.Sistema;
import seguranca.model.facade.SistemaFacade;


@Path("/sistema")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class SistemaFacadeImpl implements SistemaFacade {

	@Inject
	private SistemaDao sistemaDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.SistemaFacade#getSistemas()
	 */
	@Override
	@GET
	public List<Sistema> getSistemas() {
		return sistemaDao.getSistemas(new Sistema());
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.SistemaFacade#getSistemas(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Sistema> getSistemas(@PathParam("codigo") Integer codigo) {
		Sistema sistema = new Sistema();
		sistema.setCodigo(codigo);
		return sistemaDao.getSistemas(sistema);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.SistemaFacade#salvar(model.domain.Sistema)
	 */
	@Override
	@POST 	
	public Sistema salvar(Sistema sistema) { 
		sistema = sistemaDao.salvar(sistema);
	 	return sistema;
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.SistemaFacade#atualizar(model.domain.Sistema)
	 */
	@Override
	@PUT 
	public void atualizar(Sistema sistema) { 
		sistemaDao.atualizar(sistema);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.SistemaFacade#deletarSistema(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarSistema(@PathParam("codigo") Integer codigo) {
		Sistema sistema = new Sistema();
		sistema.setCodigo(codigo);
		sistemaDao.excluir(sistema);
	}

}
