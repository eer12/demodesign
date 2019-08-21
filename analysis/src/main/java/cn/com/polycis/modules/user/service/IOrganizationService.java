package cn.com.polycis.modules.user.service;

import cn.com.polycis.modules.user.entity.Organization;
import cn.com.polycis.modules.user.entity.Users;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-06
 */
public interface IOrganizationService extends IService<Organization> {

    Page<Organization> selectOrgPage(Integer currentPage, Integer pageSize, Organization organization);

    Users selectSysUserOfOrg(Organization organization);


    List<Organization> selectOrgList(Users user);

    Boolean insertOrg(Organization organization, Users users);

    Integer selectOrgByAppId(Integer appId);
}
