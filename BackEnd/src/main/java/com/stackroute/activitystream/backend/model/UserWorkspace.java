package com.stackroute.activitystream.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;

@Entity
@Table(name = "USERWORKSPACE")
public class UserWorkspace implements Serializable {

	private static final long serialVersionUID = 1L;

	//why constructor is required?
	public UserWorkspace(int userWorkSpaceId, String userEmailId, String userName, int workSpaceId,
			boolean isUserPartOfWorkspace, Date userJoineedWorkSpaceOn) {
		super();
		this.userWorkSpaceId = userWorkSpaceId;
		this.userEmailId = userEmailId;
		this.userName = userName;
		this.workSpaceId = workSpaceId;
		this.isUserPartOfWorkspace = isUserPartOfWorkspace;
		this.userJoineedWorkSpaceOn = userJoineedWorkSpaceOn;
	}

	public UserWorkspace() {
		super();
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userWorkSpaceId;
	@ManyToOne
	@JoinColumn(name = "USERMODEL_USEREMAIL")
	private String userEmailId;
	@Column
	@Max(value = 30)
	private String userName;
	@ManyToOne
	@JoinColumn(name = "WORKSPACE_WORKSPACEID")
	private int workSpaceId;
	
	//what is the use of this column?
	@Column
	private boolean isUserPartOfWorkspace;
	@Column
	private Date userJoineedWorkSpaceOn;
	
	//where you are storing url of the workspace?

	public int getUserWorkSpaceId() {
		return userWorkSpaceId;
	}

	public void setUserWorkSpaceId(int userWorkSpaceId) {
		this.userWorkSpaceId = userWorkSpaceId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getWorkSpaceId() {
		return workSpaceId;
	}

	public void setWorkSpaceId(int workSpaceId) {
		this.workSpaceId = workSpaceId;
	}

	public boolean isUserPartOfWorkspace() {
		return isUserPartOfWorkspace;
	}

	public void setUserPartOfWorkspace(boolean isUserPartOfWorkspace) {
		this.isUserPartOfWorkspace = isUserPartOfWorkspace;
	}

	public Date getUserJoineedWorkSpaceOn() {
		return userJoineedWorkSpaceOn;
	}

	public void setUserJoineedWorkSpaceOn() {
		this.userJoineedWorkSpaceOn = new Date();
	}

}
