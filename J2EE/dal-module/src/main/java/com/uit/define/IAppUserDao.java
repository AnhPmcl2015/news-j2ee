package com.uit.define;

import com.uit.entity.AppUser;

public interface IAppUserDao {
	AppUser findAppUserByUsername(String username);
}
