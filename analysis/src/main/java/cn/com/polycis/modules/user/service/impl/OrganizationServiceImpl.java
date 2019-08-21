package cn.com.polycis.modules.user.service.impl;

import cn.com.polycis.modules.user.dao.OrganizationMapper;
import cn.com.polycis.modules.user.dao.UsersMapper;
import cn.com.polycis.modules.user.entity.Organization;
import cn.com.polycis.modules.user.entity.Users;
import cn.com.polycis.modules.user.service.IOrganizationService;
import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static cn.com.polycis.common.utils.FinalCode.ROLE_SUSYS;
import static cn.com.polycis.common.utils.FinalCode.ROLE_SYS;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-06
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements IOrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private IOrganizationService organizationService;

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public Page<Organization> selectOrgPage(Integer currentPage, Integer pageSize, Organization organization) {
       Page<Organization> page = new Page<>(currentPage, pageSize);
        EntityWrapper<Organization> wrapper = new EntityWrapper<>();
        Organization org = new Organization();
        org.setIsDelete(1);
        wrapper.setEntity(org);
        if (organization!= null && null != organization.getName()) {
            wrapper.like("name", organization.getName(), SqlLike.DEFAULT );
        }
        wrapper.orderBy("create_time",false);
        //List<Organization> list = organizationMapper.selectPage(page, wrapper);
        Page<Organization> organizationPage = organizationService.selectPage(page, wrapper);
        List<Organization> list = organizationPage.getRecords();
        for (Organization org1 :list
                ) {
            Users users = organizationService.selectSysUserOfOrg(org1);
            if(users!=null) {
                org1.setUsers(users);
            }
        }
        return page;
        
      /*  Map<String, Object> map = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        map.put("pageNum",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("organization",organization);
        List<Map<String, Object>> list =organizationMapper.selectOrgAndSysList(map);
       Integer count = organizationMapper.selectOrgAndSysListCount(map);
        result.put("total",count);
        result.put("records",list);
        return result;*/

    }

    @Override
    public Users selectSysUserOfOrg(Organization organization) {
        Users user = new Users();
        user.setRole("sys");
        user.setOrg(organization.getId());
        List<Users> list = usersMapper.selectList(new EntityWrapper<Users>(user));
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }


    @Override
    public List<Organization> selectOrgList(Users users) {
        if (users.getRole().contains(ROLE_SUSYS)) {
            Organization organization = new Organization();
            organization.setIsDelete(1);
            EntityWrapper<Organization> wrapper = new EntityWrapper<>();
            wrapper.notIn("id", 1);
            wrapper.setEntity(organization);

            List<Organization> organizations = organizationMapper.selectList(wrapper);
            return organizations;
        } else {
            Organization organization = new Organization();
            organization.setIsDelete(1);
            organization.setId(users.getOrg());
            List<Organization> organizations = organizationMapper.selectList(new EntityWrapper<Organization>(organization));
            return organizations;
        }
    }

    @Override
    public Boolean insertOrg(Organization organization, Users users) {
        try {
            organization.setIsDelete(1);
            organization.setCreateTime(new Date());
            organizationMapper.insert(organization);
            Integer id = organization.getId();
            users.setOrg(id);
            users.setRole(ROLE_SYS);
            users.setIsDelete(1);
            users.setCreateTime(new Date());
            UUID uuid = UUID.randomUUID();
            users.setToken(uuid.toString());
            usersMapper.insert(users);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Integer selectOrgByAppId(Integer appId) {


        return organizationMapper.selectOrgByAppId(appId);
    }
}
