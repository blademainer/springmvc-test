package com.kingray.hibernate.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xiongyingqi.util.EntityHelper;
import com.xiongyingqi.utils.code.CodeHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * 基础domain，实现公共toString方法
 *
 * @author 瑛琪
 * @version 2013-7-25 下午5:06:44
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@EntityListeners({BaseDomain.class})// 实体监听，此处无效果
public abstract class BaseDomain extends EntityHelper implements Serializable {
    /**
     * 要自动插入的数据
     */
    private static Collection<BaseDomain> initDomains;

    /**
     * 要检查字段值的数据
     */
    private static Map<BaseDomain, Collection<String>> checkDomainMap;

//    /**
//     * 自动注入sessionFactory，必须要求当前线程内已经打开了Session（如果是spring则必须要求数据操作在事务范围内）
//     */
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public Session getSession() {
//        EntityHelper.print(this.sessionFactory);
//        return this.sessionFactory.getCurrentSession();
//    }

//    public Serializable save() {
//        return save(this);
//    }
//
//    public void saveOrUpdate() {
//        this.saveOrUpdate(this);
//    }
//
//    public void delete() {
//        delete(this);
//    }
//
//    public void update() {
//        update(this);
//    }
//
//
//    public Serializable save(Object entity) {
//        return getSession().save(entity);
//    }
//
//    public void saveOrUpdate(Object entity) {
//        getSession().saveOrUpdate(entity);
//    }
//
//    public void saveOrUpdate(String entityName, Object object) {
//        getSession().saveOrUpdate(entityName, object);
//    }
//
//    public void delete(Object entity) {
//        getSession().delete(entity);
//    }
//
//    public <T> T get(Class<T> clazz, Serializable id) {
//        return (T) getSession().get(clazz, id);
//    }
//
//    /**
//     * 带缓存查询 <br>
//     * 2013-8-22 下午5:08:35
//     *
//     * @param entityClass
//     * @return
//     */
//    public <T> List<T> list(Class<T> entityClass, boolean isUseCache) {
//        String entityName = entityClass.getSimpleName();
//        String hql = "from " + entityName;
//        List<T> list = getSession().createQuery(hql).setCacheable(isUseCache).list();
//        return list;
//    }
//
//    /**
//     * <br>
//     * 2013-8-22 下午5:06:55
//     *
//     * @param clazz
//     * @param id
//     * @return
//     */
//    public Object load(Class clazz, Serializable id) {
//        return getSession().load(clazz, id);
//    }
//
//    public void update(Object entity) {
//        getSession().update(entity);
//    }
//
//    public void evit(Class clazz) {
//        sessionFactory.getCache().evictEntityRegion(clazz);
//    }


    /**
     * 自动添加的静态实例，当容器启动时检查数据，如果数据不存在则插入数据 <br>
     * 2013-7-30 下午5:18:22
     *
     * @param baseDomain
     * @return
     */
    public static BaseDomain initDomain(BaseDomain baseDomain) {
        //		System.out.println(baseDomain);
        //		if(baseDomain instanceof BaseDomain){
        //			try {
        //				throw new Exception("错误的实现");
        //			} catch (Exception e) {
        //				e.printStackTrace();
        //			}
        //		} else {
        //		}
        //		System.out.println("staticSessionFactory ========== " + staticSessionFactory);
        //		Session session = staticSessionFactory.getCurrentSession();
        //		staticPublicDao.saveOrUpdate(baseDomain);
        if (initDomains == null) {
            initDomains = new HashSet<BaseDomain>();
        }
        initDomains.add(baseDomain);
        return baseDomain;
    }

    /**
     * 检查对象是否存在（按照指定的列查找）
     *
     * @param baseDomain
     * @param checkFields
     * @return
     */
    public static BaseDomain checkAndInitDomain(BaseDomain baseDomain, Collection<String> checkFields) {
        if (checkDomainMap == null) {
            checkDomainMap = new LinkedHashMap<BaseDomain, Collection<String>>();
        }
        checkDomainMap.put(baseDomain, checkFields);
        return baseDomain;
    }

    /**
     * 检查对象是否存在（按照指定的列查找）
     *
     * @param baseDomain
     * @param checkFields
     * @return
     */
    public static BaseDomain checkAndInitDomain(BaseDomain baseDomain, String... checkFields) {
        Collection<String> fields = new LinkedHashSet<String>();
        Collections.addAll(fields, checkFields);
        checkAndInitDomain(baseDomain, fields);
        return baseDomain;
    }

    /**
     * 要插入的数据 <br>
     * 2013-7-30 下午5:20:34
     *
     * @return Collection<BaseDomain>
     */
    public static Collection<BaseDomain> getInitDomains() {
        return initDomains;
    }

    public static Map<BaseDomain, Collection<String>> getCheckDomainMap() {
        return checkDomainMap;
    }

    @Override
    public String toString() {
        return EntityHelper.simpleReflectToString(this);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        CodeHelper.newCodeBuilder("D:\\workspace_JavaEE\\IWasHere\\IWasHere_ENTITY\\src\\main\\java\\com\\kingray\\hibernate\\domain").superClass(BaseDomain.class).build();
    }

    @PrePersist
    void prePersist(Object object) {
        EntityHelper.print("prePersist: " + object);
    }

    @PreUpdate
    void preUpdate(Object object) {
        EntityHelper.print("preUpdate: " + object);
    }

    @PreRemove
    void preRemove(Object object) {
        EntityHelper.print("preRemove: " + object);
    }

    @PostLoad
    void postLoad(Object object) {
        EntityHelper.print("postLoad: " + object);
    }

    @PostRemove
    void postRemove(Object object) {
        EntityHelper.print("postRemove: " + object);
    }

    @PostUpdate
    void postUpdate(Object object) {
        EntityHelper.print("postUpdate: " + object);
    }

    @PostPersist
    void postPersist(Object object) {
        EntityHelper.print("postPersist: " + object);
    }
}
