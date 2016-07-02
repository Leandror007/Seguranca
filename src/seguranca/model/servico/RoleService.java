package seguranca.model.servico;

import java.util.List;

import seguranca.model.domain.Role;

public interface RoleService {
	List<Role> getRole(Role role);
	Role salvar(Role role);
}
