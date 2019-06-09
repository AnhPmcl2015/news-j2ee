package com.uit.define;

import com.uit.common.base.IBaseDao;
import com.uit.entity.AppRole;

public interface IAppRoleDao extends IBaseDao<AppRole>{
	AppRole findByRoleName(String roleName);
	
	
}
