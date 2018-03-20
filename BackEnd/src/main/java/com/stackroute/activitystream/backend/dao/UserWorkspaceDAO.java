package com.stackroute.activitystream.backend.dao;

import java.util.List;

import com.stackroute.activitystream.backend.model.UserWorkspace;

public interface UserWorkspaceDAO {

	public boolean addUserToWorkspace(UserWorkspace userWorkSpace);
	
	public List<UserWorkspace> allWorkspaceOfUser(String userEmail); 
	
	//write all required methods as discussed in the todays scrum.
}
