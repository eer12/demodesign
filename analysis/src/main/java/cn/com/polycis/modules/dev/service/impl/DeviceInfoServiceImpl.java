package cn.com.polycis.modules.dev.service.impl;


import cn.com.polycis.modules.application.dao.AppInfoMapper;
import cn.com.polycis.modules.application.service.IAppInfoService;
import cn.com.polycis.modules.dev.dao.DeviceInfoMapper;
import cn.com.polycis.modules.dev.entity.DeviceInfo;
import cn.com.polycis.modules.dev.service.IDeviceInfoService;
import cn.com.polycis.modules.dev.service.IUnionDeviceService;
import cn.com.polycis.modules.user.entity.Users;
import cn.com.polycis.modules.user.service.IUsersService;
import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-11-30
 */
@Service
public class DeviceInfoServiceImpl extends ServiceImpl<DeviceInfoMapper, DeviceInfo> implements IDeviceInfoService {
    protected static Logger LOG = LoggerFactory.getLogger(DeviceInfoServiceImpl.class);

    @Autowired
    IDeviceInfoService iDeviceInfoService;

    @Autowired
    DeviceInfoMapper deviceInfoMapper;
    @Autowired
    IAppInfoService iAppInfoService;
    @Autowired
    IUsersService iUsersService;
    @Autowired
    AppInfoMapper appInfoMapper;
    @Autowired
    IUnionDeviceService iUnionDeviceService;


    @Override
    public DeviceInfo findDev(int id) {

        DeviceInfo dev = iDeviceInfoService.selectById(1);
        return dev;
    }


    @Override
    public int updateDev(Integer userId, DeviceInfo deviceInfo) {
        Users user = iUsersService.setByUserid(userId);
        if (user.getRole().contains("sys")) {
            deviceInfo.setUpdateTime(new Date());
            boolean flag = iDeviceInfoService.updateById(deviceInfo);
            if (flag) {
                return 200;
            } else {
                return 0;
            }

        }
        return 401;
    }




    @Override
    public Page<DeviceInfo> findAllDev(int currentPage, int pageSize, DeviceInfo deviceInfo, Users user) {

        //根据用户查询所属组织
        int orgId = user.getOrg();
        //根据组织id查询所有的应用id
        List<Integer> list = new ArrayList<>();
        if (user.getRole().equals("susys")) {
            list = appInfoMapper.selectAllAppId();
        } else {
            list = appInfoMapper.selectAppIdByorgId(orgId);
        }

        Page<DeviceInfo> page = new Page<>(currentPage, pageSize);
        EntityWrapper<DeviceInfo> dev = new EntityWrapper<DeviceInfo>(deviceInfo);
        dev.setEntity(new DeviceInfo());
        //模糊查询需要的参数 定义即可
        if (null != deviceInfo.getDescription()) {
            dev.or().like("name", deviceInfo.getDescription(), SqlLike.DEFAULT);
        }

        if (null != deviceInfo.getDescription()) {
            dev.or().like("device_uuid", deviceInfo.getDescription(), SqlLike.DEFAULT);
        }

        if (null != deviceInfo.getAppId()) {
            dev.eq("app_id", deviceInfo.getAppId());
        }
        if (null == deviceInfo.getAppId()) {
            dev.in("app_id", list);
        }
        if (null != deviceInfo.getType()) {
            dev.and().like("type", deviceInfo.getType(), SqlLike.DEFAULT);
        }
        dev.eq("is_delete", 1);
        dev.orderBy("create_time desc");

        Page<DeviceInfo> deviceInfoPage = iDeviceInfoService.selectPage(page, dev);

        return deviceInfoPage;
    }

    @Override
    public Page<DeviceInfo> findDeleteDev(int currentPage, int pageSize, DeviceInfo deviceInfo, Users user) {
        //根据用户查询所属组织
        int orgId = user.getOrg();
        if (user.getRole().equals("susys")) {
            Page<DeviceInfo> page = new Page<>(currentPage, pageSize);
            EntityWrapper<DeviceInfo> dev = new EntityWrapper<DeviceInfo>(deviceInfo);
            dev.setEntity(new DeviceInfo());
            //模糊查询需要的参数 定义即可
            if (null != deviceInfo.getDescription()) {
                dev.or().like("name", deviceInfo.getDescription(), SqlLike.DEFAULT);
            }

            if (null != deviceInfo.getDescription()) {
                dev.or().like("device_uuid", deviceInfo.getDescription(), SqlLike.DEFAULT);
            }

            if (null != deviceInfo.getType()) {
                dev.and().like("type", deviceInfo.getType(), SqlLike.DEFAULT);
            }

            if (!user.getRole().equals("susys")) {
                dev.eq("org_id", orgId);
            }
            dev.eq("app_id", -1);
            dev.eq("is_delete", 0);
            dev.orderBy("create_time desc");
            Page<DeviceInfo> deviceInfoPage = iDeviceInfoService.selectPage(page, dev);
            return deviceInfoPage;
        }
        return null;
    }

    @Override
    public Page<DeviceInfo> findDevById(int currentPage, int pageSize, DeviceInfo deviceInfo) {
        Page<DeviceInfo> page = new Page<>(currentPage, pageSize);

        EntityWrapper<DeviceInfo> dev = new EntityWrapper<DeviceInfo>(deviceInfo);
        dev.setEntity(new DeviceInfo());
        dev.eq("app_id", -1);
        dev.eq("is_delete", 1);
        dev.orderBy("create_time desc");
        Page<DeviceInfo> deviceInfoPage = iDeviceInfoService.selectPage(page, dev);
        return deviceInfoPage;
    }

    @Override
    public Page<DeviceInfo> findDevAPI(int currentPage, int pageSize, List<String> list, Users user, List<Integer> appids) {
        Page<DeviceInfo> page = new Page<>(currentPage, pageSize);
        EntityWrapper<DeviceInfo> dev = new EntityWrapper<>();

        if (appids != null) {
            dev.in("app_id", appids);
            if (!list.isEmpty()) {
                dev.in("device_uuid", list);
            }
        }
        dev.eq("org_id", user.getOrg());
        dev.orderBy("create_time desc");
        Page<DeviceInfo> deviceInfoPage = iDeviceInfoService.selectPage(page, dev);
        List<DeviceInfo> records = deviceInfoPage.getRecords();


        return deviceInfoPage;
    }


    @Override
    public int findDevNumByUserId(Integer userId) {
        //根据userId查询用户
        Users user = iUsersService.setByUserid(userId);
        Integer orgId = user.getOrg();
        //查询org下的所有应用
        List<Integer> appids = appInfoMapper.selectAppIdByorgId(orgId);
        //根据appid查询设备总数

        int num = deviceInfoMapper.selectDevNumByAppId(appids);
        return num;
    }

}
