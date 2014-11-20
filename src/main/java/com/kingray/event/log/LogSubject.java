/**
 * YIXUN_2.0
 */
package com.kingray.event.log;

import com.kingray.vo.LogVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Service事件管理类，用于中转Service事件、管理所有事件类
 * 
 * @author 瑛琪
 * @version 2013-7-29 上午10:49:14
 */
@Component
public class LogSubject {
	public static final Logger LOGGER = Logger.getLogger(LogSubject.class);

	@Autowired(required = false)
	private Collection<LogObserver> serviceEvents;

	/**
	 * <br>
	 * 2013-7-29 上午10:50:15
	 *
     */
	public void notifyDebug(LogVo log) {
		if (serviceEvents != null) {
			for (Iterator iterator = serviceEvents.iterator(); iterator.hasNext();) {
				LogObserver serviceEvent = (LogObserver) iterator.next();
				try {
					serviceEvent.debug(log);
				} catch (Exception e) {
					e.printStackTrace();
					LOGGER.error(e);
				}
			}
		}
	}

	/**
	 * <br>
	 * 2013-7-29 上午10:50:15
	 *
     */
	public void notifyInfo(LogVo log) {
		if (serviceEvents != null) {
			for (Iterator iterator = serviceEvents.iterator(); iterator.hasNext();) {
				LogObserver serviceEvent = (LogObserver) iterator.next();
				try {
					serviceEvent.info(log);
				} catch (Exception e) {
					e.printStackTrace();
					LOGGER.error(e);
				}
			}
		}
	}

	/**
	 * <br>
	 * 2013-7-29 上午10:50:15
	 *
     */
	public void notifyWarn(LogVo log) {
		if (serviceEvents != null) {
			for (Iterator iterator = serviceEvents.iterator(); iterator.hasNext();) {
				LogObserver serviceEvent = (LogObserver) iterator.next();
				try {
					serviceEvent.warn(log);
				} catch (Exception e) {
					e.printStackTrace();
					LOGGER.error(e);
				}
			}
		}
	}

	/**
	 * <br>
	 * 2013-7-29 上午10:50:15
	 *
     */
	public void notifyErro(LogVo log) {
		if (serviceEvents != null) {
			for (Iterator iterator = serviceEvents.iterator(); iterator.hasNext();) {
				LogObserver serviceEvent = (LogObserver) iterator.next();
				try {
					serviceEvent.error(log);
				} catch (Exception e) {
					e.printStackTrace();
					LOGGER.error(e);
				}
			}
		}
	}

	public void addListener(LogObserver serviceEvent) {
		if (serviceEvents == null) {
			serviceEvents = new HashSet<LogObserver>();
		}
		serviceEvents.add(serviceEvent);
	}

	/**
	 * Collection<ServiceEvent>
	 * 
	 * @param serviceEvents
	 *            the serviceEvents to set
	 */
	public void setServiceEvents(Collection<LogObserver> serviceEvents) {
		this.serviceEvents = serviceEvents;
	}

    public Collection<LogObserver> getServiceEvents() {
        return serviceEvents;
    }
}
