package seguranca.model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import seguranca.model.domain.Role;
import seguranca.model.servico.RoleService;

@Path("/role")
@Produces({MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class RoleFacade {
	
	@Inject
	private RoleService roleService;
	
	@GET
	public List<Role> getRoleSemParametros() {
		return roleService.getRole(new Role());
	}
	
	@GET
	@Path("/{codigoRole}")
	public List<Role> getRole(
			@PathParam("codigoRole")Integer codigoRole) {
		Role role = new Role();
		role.setCodigo(codigoRole);
		return roleService.getRole(role);
	}
	
	@POST
	public Role enviarRole(Role role) {
		return roleService.salvar(role);		
	}

}
