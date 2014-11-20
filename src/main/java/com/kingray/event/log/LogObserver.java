/**
 * YIXUN_2.0
 */
package com.kingray.event.log;

import com.kingray.vo.LogVo;

/**
 * 日志类监听接口
 * 
 * @author 瑛琪
 * @version 2013-7-29 上午10:46:11
 */
public interface LogObserver {
	/**
	 * 对应log debug级别 <br>
	 * 2013-7-29 上午10:48:39
	 * 
	 * @param log
	 */
	public void debug(LogVo log) throws Exception;

	/**
	 * 对应log info级别 <br>
	 * 2013-7-29 上午10:48:42
	 * 
	 * @param log
	 */
	public void info(LogVo log) throws Exception;

	/**
	 * 对应log warn级别 <br>
	 * 2013-7-29 上午10:48:45
	 * 
	 * @param log
	 */
	public void warn(LogVo log) throws Exception;

	/**
	 * 对应log erro级别 <br>
	 * 2013-7-29 上午10:48:48
	 * 
	 * @param log
	 */
	public void error(LogVo log) throws Exception;
}
