package com.adilmx.aopcustomannotations.context;

import com.adilmx.aopcustomannotations.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface CustomSecurityContext {
    public int Authenticate(String username, String password);
    public int hasRole(String[] roles);
}
