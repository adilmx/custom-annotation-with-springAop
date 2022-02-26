package com.adilmx.aopcustomannotations.context.impl;

import com.adilmx.aopcustomannotations.context.CustomSecurityContext;
import com.adilmx.aopcustomannotations.model.User;
import org.springframework.stereotype.Service;

@Service
public class CustomSecurityContextImpl implements CustomSecurityContext {
    private static User adminUser ;
    private static String[] rolesApp = {"ADMIN","USER","MANAGER"};


    public CustomSecurityContextImpl() {
        adminUser = new User();
        adminUser.setId(1L);
        adminUser.setUsername("root");
        adminUser.setPassword("root");
        String[] rolesUser = {"ADMIN"};
        adminUser.setRoles(rolesUser);
    }

    @Override
    public int Authenticate(String username, String password){
        if(username.equals(adminUser.getUsername()) && password.equals(adminUser.getPassword())){
            return 1;
        }
        return -1;
    }
    @Override
    public int hasRole(String[] roles){
        for (String r:roles) {
            for (String role: adminUser.getRoles()) {
                if(role.equals(r)){
                    return 1;
                }
            }
        }
        return -1;
    }

}
