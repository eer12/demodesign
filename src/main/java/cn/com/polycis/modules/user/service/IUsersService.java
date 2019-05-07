package cn.com.polycis.modules.user.service;

import cn.com.polycis.modules.user.entity.Users;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-11-29
 */
public interface IUsersService extends IService<Users> {

    /**
     * 登录使用
     *
     * @param uss 必须传入登录名和密码
     * @return
     */
    Users isUser(Users uss);

    /**
     * 根据用户标识查询用户信息
     *
     * @param usid
     * @return
     */
    Users setByUserid(Integer usid);

    /**
     * 根据用户id查询用户缓存信息
     *
     * @param userid
     * @return
     */
    Users seltUserBybiInRedis(Integer userid);





    /**
     * 根据token查询用户
     * @param accessToken
     * @return
     */
    Users selectbytokne(String accessToken);

    List<Map<String, Object>> selectRoleList(Users users);

    Boolean checkLoginNameUnique(String loginName);

    Users selectAdminByOrg(Integer orgId);
}
