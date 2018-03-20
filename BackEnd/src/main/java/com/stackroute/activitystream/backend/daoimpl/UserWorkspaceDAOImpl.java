package com.stackroute.activitystream.backend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.activitystream.backend.dao.UserWorkspaceDAO;
import com.stackroute.activitystream.backend.model.UserWorkspace;

//Did you tested this DAO?
public class UserWorkspaceDAOImpl implements UserWorkspaceDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	//define all other methods as discussed in the scrum.

	@Override
	public boolean addUserToWorkspace(UserWorkspace userWorkSpace) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.openSession().save(userWorkSpace);
			} catch (Exception e) {
				sessionFactory.getCurrentSession().save(userWorkSpace);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserWorkspace> allWorkspaceOfUser(String userEmail) {
		// TODO Auto-generated method stub
		List<UserWorkspace> allWorkspaceOfAnUser=null;
		try {
			try {
				Criteria criteria=sessionFactory.openSession().createCriteria(UserWorkspace.class);
				criteria.add(Restrictions.eq("userEmailId", userEmail));
				allWorkspaceOfAnUser=criteria.list();
			} catch (Exception e) {
				Criteria criteria=sessionFactory.getCurrentSession().createCriteria(UserWorkspace.class);
				criteria.add(Restrictions.eq("userEmailId", userEmail));
				allWorkspaceOfAnUser=criteria.list();
			}
			return allWorkspaceOfAnUser;
		} catch (Exception e) {
			return allWorkspaceOfAnUser;
		}
	}
	
	
	

}
