package seguranca.model.dao;

import java.util.List;

import seguranca.model.domain.Role;

public interface RoleDao {

	List<Role> getRoles();
	
	public void excluir(Role role);
	
	public Role salvar(Role role);
	
	public void atualizar(Role role);

}
