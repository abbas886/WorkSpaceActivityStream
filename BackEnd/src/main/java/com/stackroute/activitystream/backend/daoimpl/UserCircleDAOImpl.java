package com.stackroute.activitystream.backend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.activitystream.backend.dao.UserCircleDAO;
import com.stackroute.activitystream.backend.model.CircleModel;
import com.stackroute.activitystream.backend.model.UserCircleModel;

public class UserCircleDAOImpl implements UserCircleDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUserToCircle(UserCircleModel userCircleModel) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.getCurrentSession().save(userCircleModel);
			} catch (Exception e) {
				sessionFactory.openSession().save(userCircleModel);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<UserCircleModel> allCircleOfAnUserinWorkspace(int workspaceId, String userEmailId) {
		// TODO Auto-generated method stub
		List<UserCircleModel> allCircleOfAnUserInWorkspace = null;
		try {
			try {
				Criteria criteria = sessionFactory.openSession().createCriteria(CircleModel.class);
				criteria.add(Restrictions.eq("workSpaceId", workspaceId));
				criteria.add(Restrictions.eq("userEmailId", userEmailId));
				allCircleOfAnUserInWorkspace = criteria.list();
			} catch (Exception e) {
				Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CircleModel.class);
				criteria.add(Restrictions.eq("workSpaceId", workspaceId));
				criteria.add(Restrictions.eq("userEmailId", userEmailId));
				allCircleOfAnUserInWorkspace = criteria.list();
			}
			return allCircleOfAnUserInWorkspace;
		} catch (Exception e) {
			return allCircleOfAnUserInWorkspace;
		}
	}

}
