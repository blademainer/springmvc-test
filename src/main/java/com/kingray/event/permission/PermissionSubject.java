/**
 * YIXUN_1.5_EE
 */
package com.kingray.event.permission;

import com.kingray.hibernate.domain.PUser;
import com.kingray.hibernate.domain.YxPermission;
import com.kingray.hibernate.domain.YxRole;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 权限信息主持者
 * 
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-11-1 下午3:31:04
 */
// 让spring扫描到主持者
@Component
public class PermissionSubject {
	public static final Logger LOGGER = Logger.getLogger(PermissionSubject.class);

	// 使用spring的自动注入，只要是实现了PermissionObserver的类都会被自动注入observers集合
	@Autowired(required = false)
	private Collection<PermissionObserver> observers;

	/**
	 * 通知观察者新增了系统权限 <br>
	 * 2013-11-1 下午3:38:21
	 * 
	 * @see com.kingray.event.permission.PermissionObserver#systemPermissionAdded(com.kingray.hibernate.domain.YxPermission)
	 */
	public void notifySystemPermissionAdded(YxPermission permission) {
		if (observers == null) {
			return;
		}
		for (PermissionObserver observer : observers) {
			try {
				observer.systemPermissionAdded(permission);
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error(e);
			}
		}
	}

	/**
	 * 通知观察者删除系统权限 <br>
	 * 2013-11-1 下午3:38:21
	 * 
	 * @see com.kingray.event.permission.PermissionObserver#systemPermissionDeleted(com.kingray.hibernate.domain.YxPermission)
	 */
	public void notifySystemPermissionDeleted(YxPermission permission) {
		if (observers == null) {
			return;
		}
		for (PermissionObserver observer : observers) {
			try {
				observer.systemPermissionDeleted(permission);
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error(e);
			}
		}
	}

	/**
	 * 通知观察者新增了角色权限 <br>
	 * 2013-11-1 下午3:38:21
	 * 
	 * @see com.kingray.event.permission.PermissionObserver#userPermissionAddedForRole(com.kingray.hibernate.domain.YxRole,
	 *      com.kingray.hibernate.domain.YxPermission)
	 */
	public void notifyUserPermissionAddedForRole(YxRole role, YxPermission permission) {
		if (observers == null) {
			return;
		}
		for (PermissionObserver observer : observers) {
			try {
				observer.userPermissionAddedForRole(role, permission);
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error(e);
			}
		}
	}

	/**
	 * 通知观察者删除了角色权限 <br>
	 * 2013-11-1 下午3:38:21
	 * 
	 * @see com.kingray.event.permission.PermissionObserver#userPermissionDeletedForRole(com.kingray.hibernate.domain.YxRole,
	 *      com.kingray.hibernate.domain.YxPermission)
	 */
	public void notifyUserPermissionDeletedForRole(YxRole role, YxPermission permission) {
		if (observers == null) {
			return;
		}
		for (PermissionObserver observer : observers) {
			try {
				observer.userPermissionDeletedForRole(role, permission);
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error(e);
			}
		}
	}

	/**
	 * 通知观察者为用户新增了角色 <br>
	 * 2013-11-1 下午3:38:21
	 * 
	 * @see com.kingray.event.permission.PermissionObserver#userRoleAdded(com.kingray.hibernate.domain.PUser,
	 *      com.kingray.hibernate.domain.YxRole)
	 */
	public void notifyUserRoleAdded(PUser user, YxRole role) {
		if (observers == null) {
			return;
		}
		for (PermissionObserver observer : observers) {
			try {
				observer.userRoleAdded(user, role);
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error(e);
			}
		}
	}

	/**
	 * 通知观察者删除了用户的角色信息<br>
	 * 2013-11-1 下午3:38:21
	 * 
	 */
	public void notifyUserRoleDeleted(PUser user, YxRole role) {
		if (observers == null) {
			return;
		}
		for (PermissionObserver observer : observers) {
			try {
				observer.userRoleDeleted(user, role);
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error(e);
			}
		}
	}

}
