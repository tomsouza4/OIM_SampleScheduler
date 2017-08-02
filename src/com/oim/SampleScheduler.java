package com.oim;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oracle.iam.identity.usermgmt.api.UserManager;
import oracle.iam.identity.usermgmt.vo.User;
import oracle.iam.platform.Platform;
import oracle.iam.platform.entitymgr.vo.SearchCriteria;
import oracle.iam.platform.entitymgr.vo.SearchCriteria.Operator;
import oracle.iam.scheduler.vo.TaskSupport;

public class SampleScheduler extends TaskSupport {
	@Override
	public void execute(HashMap arg0) throws Exception {
		UserManager usrMgr = Platform.getService(UserManager.class);
		SearchCriteria sc = new SearchCriteria("User Login", "*", Operator.EQUAL);
		Set<String> retAttrs = new HashSet<String>();
		retAttrs.add("User Login");
		List<User> users = usrMgr.search(sc, retAttrs, null);
		for (User user : users) {
			System.out.println(user.getLogin());
		}
	}

	@Override
	public HashMap getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttributes() {
		// TODO Auto-generated method stub
	}
}