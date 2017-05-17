package com.khh.web.service.impl;

import com.khh.web.dao.PersonMapper;
import com.khh.web.domain.Person;
import com.khh.web.service.interface_.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 951087952@qq.com on 2017/5/16.
 */
@Service("personService")
public class PersonServiceImpl implements PersonService{

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private PersonMapper personMapper;

    @Override
    public int insert(Person person) {
        return personMapper.insert(person);
    }

    @Override
    public Person findForLogin(Person person) {
        return personMapper.findForLogin(person);
    }

    @Override
    public Person findByEmail(String email) {
        return personMapper.findByEmail(email);
    }

    @Override
    public Person findByAccount(String account) {
        return personMapper.findByAccount(account);
    }

    @Override
    public Person findByPhone(String phone) {
        return personMapper.findByPhone(phone);
    }
}
