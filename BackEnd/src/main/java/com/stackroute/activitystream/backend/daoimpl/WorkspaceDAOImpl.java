package com.stackroute.activitystream.backend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.activitystream.backend.dao.WorkspaceDAO;
import com.stackroute.activitystream.backend.model.Workspace;


//Did you tested this DAO?
public class WorkspaceDAOImpl implements WorkspaceDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	//define all required methods.
	
	
	@Override
	public boolean createWorkspace(Workspace workspace) {
		// TODO Auto-generated method stub
		try {
			try {
				sessionFactory.getCurrentSession().save(workspace);
			} catch (Exception e) {
				sessionFactory.openSession().save(workspace);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
