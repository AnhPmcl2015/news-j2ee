package com.uit.define;

import com.uit.common.base.IBaseDao;
import com.uit.entity.AppUser;

public interface IAppUserDao extends IBaseDao<AppUser>{
	AppUser findAppUserByUsername(String username);
}
