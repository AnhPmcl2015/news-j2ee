package com.uit.define;

import com.uit.entity.Appuser;

public interface IAppUserDao {
	Appuser findAppUserByUsername(String username);
}
