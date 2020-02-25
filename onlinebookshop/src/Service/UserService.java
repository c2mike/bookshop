package Service;

import Dao.User;
import Dao.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private UserDao userdao = new UserDao();
    public void adduser(String username,String password,String address,String email,String phone)
    {
        User user = new User();
        user.setPassword(password);
        user.setAddress(address);
        user.setEmail(email);
        user.setPhone(phone);
        user.setUsername(username);
        userdao.insertone(user);
    }

    public User login(String username, String password)
    {
        Map<String,String> param = new HashMap<String,String>();
        param.put("username",username);
        param.put("password",password);
        List<User> list = userdao.selectall(param);
        for(User user:list)
        {
            if(user.getUsername().equals(username)&&user.getPassword().equals(password))
            {
                return user;
            }
        }
        return null;
    }

    public void finduserprivilege(User user)

    {
        userdao.selectprivilege(user);
    }
}
