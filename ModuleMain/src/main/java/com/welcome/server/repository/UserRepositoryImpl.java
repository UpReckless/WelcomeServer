package com.welcome.server.repository;

import com.welcome.server.entity.User;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

/**
 * Created by ivanf on 12.10.2016.
 */
public class UserRepositoryImpl implements UserRepositoryCustom{

    @Autowired
    EntityManager entityManager;

    public boolean checkUserName(String name) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq=cb.createQuery(User.class);
        Root<User> from=cq.from(User.class);
        ParameterExpression<String> p=cb.parameter(String.class);
        cq.select(from).where(cb.equal(from.get("nickname"),p));

        TypedQuery<User> query=entityManager.createQuery(cq);
        query.setParameter(p,name);

        return query.getResultList().size() > 0;
    }

    @Override
    public boolean checkCredentials(String imei, long id) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq=cb.createQuery(User.class);
        Root<User> from=cq.from(User.class);
        ParameterExpression<String> p1=cb.parameter(String.class);
        ParameterExpression<Long> p2=cb.parameter(Long.class);
        Predicate predicate=cb.and(cb.equal(from.get("imei"),p1),cb.equal(from.get("id"),p2));
        cq.select(from).where(predicate);
        TypedQuery<User> query=entityManager.createQuery(cq);
        query.setParameter(p1,imei);
        query.setParameter(p2,id);
        query.setMaxResults(1);
        return !query.getResultList().isEmpty();
    }
}
