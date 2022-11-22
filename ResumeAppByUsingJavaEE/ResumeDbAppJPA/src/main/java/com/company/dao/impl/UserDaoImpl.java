package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private final BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public List<User> getAllUser(String name, String surname, Integer nId) {
        EntityManager em = em();
        String jpql = "select u from User u where 1=1";

//        List<User> result = new ArrayList<>();
//        try ( Connection c = connect()) {
//            String query = "select u.* ,c2.name as birthplace,c1.nationality "
//                    + "from user u "
//                    + " left join country c1 on c1.id = u.nationality_id "
//                    + " left join country c2 on c2.id = u.birthplace_id where 1=1";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname";
        }
        if (nId != null) {
            jpql += " and u.nationality.id=:nid";
        }
        Query query = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);

        }
        if (nId != null) {
            query.setParameter("nid", nId);

        }
        return query.getResultList();
    }

    @Override
    public User findEmailAndPassword(String email, String password) {
        EntityManager em = em();
        Query query = em.createQuery("select u from User u where u.email=:e and u.password=:p", User.class);
        query.setParameter("e", email);
        query.setParameter("p", password);
        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    //JPQL(Java Persistence Query Language)
//    @Override
//    public User findEmail(String email) {
//        EntityManager em = em();
//        Query query = em.createQuery("select u from User u where u.email=:e", User.class);
//        query.setParameter("e", email);
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
    
    //CriteriaBuilder
//    @Override
//    public User findEmail(String email) {
//        EntityManager em = em();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> cq = cb.createQuery(User.class);
//        Root user = cq.from(User.class);
//        CriteriaQuery<User> cqw = cq.where(cb.equal(user.get("email"), email));
//        Query query = em.createQuery(cqw);
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
    
    //NamedQuery
//    @Override
//    public User findEmail(String email) {
//        EntityManager em = em();
//        Query query = em.createNamedQuery("User.findByEmail", User.class);
//        query.setParameter("email", email);
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }

    //Native SQL
    @Override
    public User findEmail(String email) {
        EntityManager em = em();
        Query query = em.createNativeQuery("select * from user where email=?", User.class);
        query.setParameter(1, email);
        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
    @Override
    public boolean updateUser(User u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        EntityManager em = em();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public User getById(int userId) {
        EntityManager em = em();
        User user = em.find(User.class, userId);
        em.close();
        return user;
    }

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
