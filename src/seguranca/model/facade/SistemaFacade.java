package seguranca.model.facade;

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

@Path("/sistema")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class SistemaFacade {
	
	@Inject
	private SistemaDao sistemaDao;
	
	@GET
	@Path("/usuarioLogado")
	public List<Sistema> getSistemasUsuarioLogado() {
		return sistemaDao.getSistemasUsuarioLogado();
	}
	
	@GET	
	public List<Sistema> getSistemas() {
		return sistemaDao.getSistemas();
	}
	
	@POST 	
	public Sistema salvar(Sistema sistema) { 
		sistema = sistemaDao.salvar(sistema);
	 	return sistema;
	}
		
	@PUT 
	public void atualizar(Sistema sistema) { 
		sistemaDao.atualizar(sistema);
	}
	
	@DELETE
	@Path("/{codigo}")
	public void deletar(@PathParam("codigo") Integer codigo) {
		Sistema sistema = new Sistema();
		sistema.setCodigo(codigo);
		sistemaDao.excluir(sistema);
	}

}
