package cn.com.polycis.modules.user.dao;

import cn.com.polycis.modules.user.entity.Users;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-11-29
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {


    Users selectSysUserByOrgId(Integer organizationId);

}
