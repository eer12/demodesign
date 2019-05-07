package cn.com.polycis.modules.dev.service;

import cn.com.polycis.modules.dev.entity.DeviceInfo;
import cn.com.polycis.modules.user.entity.Users;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 设备表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-11-30
 */
public interface IDeviceInfoService extends IService<DeviceInfo> {

    /**
     * 查询设备测试`
     * @param id
     * @return
     */
    DeviceInfo findDev(int id);


    /**
     * 修改设备
     * @param deviceInfo
     * @return
     */
    int updateDev(Integer userId, DeviceInfo deviceInfo);



    /**
     * 查询所有设备
     * @param deviceInfo
     * @return
     */
    Page<DeviceInfo> findAllDev(int currentPage, int pageSize, DeviceInfo deviceInfo, Users user);

    /**
     * 查询所有设备
     * @param deviceInfo
     * @return
     */
    Page<DeviceInfo> findDeleteDev(int currentPage, int pageSize, DeviceInfo deviceInfo, Users user);


    /**
     * 查询未绑定绑定设备信息
     * @param deviceInfo
     * @return
     */
    Page<DeviceInfo> findDevById(int currentPage, int pageSize, DeviceInfo deviceInfo);

    /**
     * 查询所有设备(对外api)
     * @param
     * @return
     */
    Page<DeviceInfo> findDevAPI(int currentPage, int pageSize, List<String> list, Users user, List<Integer> appIds);
    /**
     * 查询绑定设备信息
     * @return
     */
    int findDevNumByUserId(Integer userId);

}
