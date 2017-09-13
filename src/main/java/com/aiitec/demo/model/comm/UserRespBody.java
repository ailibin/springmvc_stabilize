package com.aiitec.demo.model.comm;

import com.aiitec.base.model.comm.AbstractRespBody;

import java.util.List;

public class UserRespBody extends AbstractRespBody {
    public int total;
    public List<User> users;


    public UserRespBody(List<User> user){
//            ArrayList<UserMap> input = new ArrayList<UserMap>();
//            for(User u:user){
//                input.add(new UserMap(u));
//            }
//            this.total = user.size();
        this.users = user;
    }

    public static class User {
        public String name;
        public int id;
    }


}
