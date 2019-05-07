package cn.com.polycis.modules.user.dao;

import cn.com.polycis.modules.user.entity.Organization;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-06
 */
public interface OrganizationMapper extends BaseMapper<Organization> {

    List<Map<String,Object>> selectOrgAndSysList(Map<String, Object> map);

    Integer selectOrgAndSysListCount(Map<String, Object> map);

    Integer selectOrgByAppId(Integer appId);
}
