package cn.com.polycis.modules.user.service.impl;

import cn.com.polycis.common.utils.RedisUtils;
import cn.com.polycis.modules.user.dao.UsersMapper;
import cn.com.polycis.modules.user.entity.Users;
import cn.com.polycis.modules.user.service.IUsersService;
import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.com.polycis.common.utils.FinalCode.*;
import static cn.com.polycis.common.utils.RedisUtils.NOT_EXPIRE;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-11-29
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 查看是否是有此账户
     *
     * @param uss
     * @return
     */
    @Override
    public Users isUser(Users uss) {
        List<Users> users = this.selectList(new EntityWrapper<Users>(uss));
        if (!users.isEmpty()) {
            redisUtils.set(String.valueOf(users.get(0).getId()),users.get(0),NOT_EXPIRE);
            return users.get(0);
        }
        return null;
    }

    @Override
    public Users setByUserid(Integer usid) {
        return this.selectById(usid);
    }

    @Override
    public Users seltUserBybiInRedis(Integer userid) {
        Users users = redisUtils.get(String.valueOf(userid), Users.class);
        if (users == null) {
            users = this.setByUserid(userid);
            redisUtils.set(String.valueOf(users.getId()),users,NOT_EXPIRE);
        }
        return users;
    }


    @Override
    public List<Map<String, Object>> selectRoleList(Users users) {
       List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        if(users.getRole().contains(ROLE_SUSYS)){
            Map<String, Object> map2 = new HashMap<>();
            map2.put("role",ROLE_SYS);
            map2.put("name","管理员");
            list.add(map2);
        }
        list.add(map1);
        map1.put("role",ROLE_USER);
        map1.put("name","用户");
        return list;
    }

    @Override
    public Boolean checkLoginNameUnique(String loginName) {
        Users users = new Users();
        users.setIsDelete(1);
        users.setLoginname(loginName);
        List<Users> list = usersMapper.selectList(new EntityWrapper<Users>(users));
        if(list !=null && list.size()>0){
            return false;
        }
        return true;
    }

    @Override
    public Users selectAdminByOrg(Integer orgId) {
        Users users = new Users();
        users.setOrg(orgId);
        users.setRole("sys");
        List<Users> list = this.selectList(new EntityWrapper<Users>(users));
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public Users selectbytokne(String accessToken) {

        List<Users> users = this.selectList(new EntityWrapper<Users>().eq("token", accessToken));
        if (!users.isEmpty()){
            return users.get(0);
        }
        return null;

    }
}
