package seguranca.model.dao;

import java.util.List;

import seguranca.model.domain.Role;

public interface RoleDao {
	
	List<Role> getRole(Role role);

	Role salvar(Role role);
	
	public void atualizar(Role role);


}
