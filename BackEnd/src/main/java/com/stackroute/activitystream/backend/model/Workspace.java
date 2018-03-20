package com.stackroute.activitystream.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;

@Entity
@Table(name = "WORKSPACE")
public class Workspace implements Serializable {

	private static final long serialVersionUID = 1L;

	//why this constructor??
	public Workspace(int workSpaceId, String workSpaceName, String workSpaceAdminName, String workSpaceAdminPassword,
			Date workSpaceCreatedOn, boolean isWorkSpaceActive) {
		super();
		this.workSpaceId = workSpaceId;
		this.workSpaceName = workSpaceName;
		this.workSpaceAdminName = workSpaceAdminName;
		this.workSpaceAdminPassword = workSpaceAdminPassword;
		this.workSpaceCreatedOn = workSpaceCreatedOn;
		this.isWorkSpaceActive = isWorkSpaceActive;
	}

	public Workspace() {
		super();
	}

	//did you created tables manually OR generated?
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL)
	private int workSpaceId;
	@Column
	@Max(value = 50)
	private String workSpaceName;
	@Column
	@Max(value = 30)
	private String workSpaceAdminName;
	@Column
	@Max(value = 15)
	private String workSpaceAdminPassword;
	@Column
	private Date workSpaceCreatedOn;
	@Column
	private boolean isWorkSpaceActive;

	//where you are storing workspace url?
	public int getWorkSpaceId() {
		return workSpaceId;
	}

	public void setWorkSpaceId(int workSpaceId) {
		this.workSpaceId = workSpaceId;
	}

	public String getWorkSpaceName() {
		return workSpaceName;
	}

	public void setWorkSpaceName(String workSpaceName) {
		this.workSpaceName = workSpaceName;
	}

	public String getWorkSpaceAdminName() {
		return workSpaceAdminName;
	}

	public void setWorkSpaceAdminName(String workSpaceAdminName) {
		this.workSpaceAdminName = workSpaceAdminName;
	}

	public String getWorkSpaceAdminPassword() {
		return workSpaceAdminPassword;
	}

	public void setWorkSpaceAdminPassword(String workSpaceAdminPassword) {
		this.workSpaceAdminPassword = workSpaceAdminPassword;
	}

	public Date getWorkSpaceCreatedOn() {
		return workSpaceCreatedOn;
	}

	public void setWorkSpaceCreatedOn() {
		this.workSpaceCreatedOn = new Date();
	}

	public boolean isWorkSpaceActive() {
		return isWorkSpaceActive;
	}

	public void setWorkSpaceActive(boolean isWorkSpaceActive) {
		this.isWorkSpaceActive = isWorkSpaceActive;
	}

}
