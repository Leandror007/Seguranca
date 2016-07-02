package seguranca.model.servico;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.transaction.Transactional;

import seguranca.model.dao.RoleDao;
import seguranca.model.domain.Role;

//@JMSDestinationDefinition(name = "java:/jms/queue/roleQueue", 
//destinationName = "roleQueue", description = "roleQueue", interfaceName = "javax.jms.Queue")
public class RoleServiceImpl implements RoleService {
	
	@Inject
	private RoleDao roleDao;
	
	@Inject
	private JMSContext jmsContext;
	
	@Resource(lookup="java:/jms/queue/roleQueue")
	private Queue fila;
	
	/* (non-Javadoc)
	 * @see model.service.RoleService#salvar(model.domain.Role)
	 */
	@Override
	@Transactional
	public Role salvar(Role role) {
		role = roleDao.salvar(role);
		jmsContext.createProducer().send(fila,role);
		return role;
	}
	
	/* (non-Javadoc)
	 * @see model.service.RoleService#getRoles(model.domain.Role)
	 */
	@Override
	public List<Role> getRole(Role role) {
		return roleDao.getRole(role);
	}
	
	
	
}
