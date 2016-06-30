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

import seguranca.model.dao.RoleDao;
import seguranca.model.domain.Role;

@Path("/role")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class RoleFacade {
	
	@Inject
	private RoleDao roleDao;
	
	@GET
	public List<Role> getRoles() {
		return roleDao.getRoles();
	}
	
	@POST 	
	public Role salvar(Role role) { 
		role = roleDao.salvar(role);
	 	return role;
	}
		
	@PUT 
	public void atualizar(Role role) { 
		roleDao.atualizar(role);
	}
	
	@DELETE
	@Path("/{codigo}")
	public void deletar(@PathParam("codigo") Integer codigo) {
		Role role = new Role();
		role.setCodigo(codigo);
		roleDao.excluir(role);
	}

}
