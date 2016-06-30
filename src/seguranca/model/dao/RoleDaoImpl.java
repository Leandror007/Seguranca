package seguranca.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import seguranca.model.domain.Role;

public class RoleDaoImpl implements RoleDao {
	
	@PersistenceContext(unitName="SegurancaPU")
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Role> getRoles() {
		StringBuffer hql = new StringBuffer("from Role r"
				+ " where 1 = 1");	
		Query query = entityManager.createQuery(hql.toString());
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Role role) {
		role = entityManager.merge(role);
		entityManager.remove(role);
	}

	@Override
	@Transactional
	public Role salvar(Role role) {
		entityManager.persist(role);
		return role;
	}

	@Override
	@Transactional
	public void atualizar(Role role) {
		role = entityManager.merge(role);
		entityManager.persist(role);		
	}

}
