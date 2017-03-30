package org.smart4j.chapter2.systemodule.UserService;

import org.smart4j.chapter2.systemodule.UserModel.User;
import org.smart4j.chapter2.basicmodule.helper.DatabaseHelper;
import org.smart4j.chapter2.basicmodule.util.StringUtil;

/**
 * Created by dingcc on 2017/3/27.
 */
public class UserService {
   public Boolean getUser(User user){
      StringBuffer sql=new StringBuffer("SELECT u.id,u.username,u.`password` FROM `user` u WHERE 1=1");
       Boolean LogSign=Boolean.FALSE;
       if (StringUtil.isNotEmpty(user.getUsername())&& !"null".equals(user.getUsername())){
           sql.append(" AND u.username='"+user.getUsername().trim()+"'");
       }
       if (StringUtil.isNotEmpty(user.getPassword())&& !"null".equals(user.getPassword())){
           sql.append(" AND u.password='"+user.getPassword().trim()+"'");
       }
       User Entity = DatabaseHelper.queryEntity(User.class, sql.toString());
       if (null!=Entity){
           LogSign=Boolean.TRUE;
       }
       return LogSign;
   }
}
