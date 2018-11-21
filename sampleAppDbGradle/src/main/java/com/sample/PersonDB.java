package com.sample;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class PersonDB extends AbstractDB<Person, Integer>{
    public PersonDB() {
        super(Person.class);
    }

    public List<Person> getList(){
        // TODO SQLをパラメータに
        List<Person> list = getEntityManager().createQuery(
                "SELECT p FROM Person p", Person.class).getResultList();        
        return list;
    }
    
    public List<Person> getList(String cond){
        Query query = getEntityManager().createQuery(
                "SELECT p FROM Person p WHERE p.name LIKE ?1", Person.class);
        // TODO 手抜き
        query.setParameter(1, "%" + cond + "%");
        return query.getResultList();
    }
}
