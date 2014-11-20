/**
 * YIXUN_1.5_EE
 */
package com.kingray.event.permission;

import com.kingray.hibernate.domain.PUser;
import com.kingray.hibernate.domain.YxPermission;
import com.kingray.hibernate.domain.YxRole;

/**
 * 权限信息监听<br>
 * 当后台增加了系统级权限时通知systemPermissionAdded方法<br>
 * 当后台删除了系统级权限时通知systemPermissionDeleted方法<br>
 * 
 * 当后台为角色增加了权限时通知userPermissionAddedForRole方法<br>
 * 当后台为角色删除了权限时通知userPermissionDeletedForRole方法<br>
 * 
 * @see #systemPermissionAdded(com.kingray.hibernate.domain.YxPermission)
 * @see #systemPermissionDeleted(com.kingray.hibernate.domain.YxPermission)
 * @see #userPermissionAddedForRole(com.kingray.hibernate.domain.YxRole, com.kingray.hibernate.domain.YxPermission)
 * @see #userPermissionDeletedForRole(com.kingray.hibernate.domain.YxRole, com.kingray.hibernate.domain.YxPermission)
 * 
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-11-1 下午3:06:35
 */
public interface PermissionObserver {

	/**
	 * 系统新增了敏感权限 <br>
	 * 2013-11-1 下午3:10:49
	 * 
	 * @param permission
	 *            新增加的权限
	 */
	public void systemPermissionAdded(YxPermission permission);

	/**
	 * 系统删除了敏感权限 <br>
	 * 2013-11-1 下午3:14:57
	 * 
	 * @param permission
	 *            删除的权限
	 */
	public void systemPermissionDeleted(YxPermission permission);

	/**
	 * 后台为角色新增了权限 <br>
	 * 2013-11-1 下午3:11:56
	 * 
	 * @param role
	 *            目标角色
	 * @param permission
	 *            新增的权限
	 */
	public void userPermissionAddedForRole(YxRole role, YxPermission permission);

	/**
	 * 后台为角色删除了权限 <br>
	 * 2013-11-1 下午3:11:56
	 * 
	 * @param role
	 *            目标角色
	 * @param permission
	 *            删除的权限
	 */
	public void userPermissionDeletedForRole(YxRole role, YxPermission permission);

	/**
	 * 用户新增了角色 <br>
	 * 2013-11-7 下午9:06:37
	 * 
	 * @param user
	 *            用户
	 * @param role
	 *            新增的角色
	 */
	public void userRoleAdded(PUser user, YxRole role);

	/**
	 * 删除了用户的某个角色 <br>
	 * 2013-11-7 下午9:07:23
	 * 
	 * @param user
	 *            用户
	 * @param role
	 *            删除的角色
	 */
	public void userRoleDeleted(PUser user, YxRole role);

}
