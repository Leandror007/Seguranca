package seguranca.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import seguranca.model.domain.Role;

public class RoleDaoImpl implements RoleDao {

@PersistenceContext(unitName="SegurancaPU")
private EntityManager entityManager;


/* (non-Javadoc)
 * @see model.dao.RoleDao#salvar(model.domain.Role)
 */
@Override
public Role salvar(Role role) {
	entityManager.persist(role);
	return role;
}

/* (non-Javadoc)
 * @see model.dao.RoleDao#salvar(model.domain.Role)
 */
@Override
public void atualizar(Role role) {
	role = entityManager.merge(role);
	entityManager.persist(role);
}

/* (non-Javadoc)
 * @see model.dao.RoleDao#getRoles(model.domain.Role)
 */
@Override
@SuppressWarnings("unchecked")
public List<Role> getRole(Role role) {
	StringBuilder hql = new StringBuilder(
			"from Role s where 1 = 1 ");
	if (role.getCodigo() != null) {
		hql.append("and s.codigo = :codigo");
	}
	Query query = entityManager.createQuery(hql.toString());
	if (role.getCodigo() != null) {
		query.setParameter("codigo",role.getCodigo());
	}
	return query.getResultList();
}

}
