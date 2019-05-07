package cn.com.polycis.modules.dev.service.impl;

import cn.com.polycis.modules.dev.dao.DeviceUplinkDataMapper;
import cn.com.polycis.modules.dev.entity.DataList;
import cn.com.polycis.modules.dev.entity.DeviceUplinkData;
import cn.com.polycis.modules.dev.service.IDeviceUplinkDataService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备上行数据表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-11-30
 */
@Service
public class DeviceUplinkDataServiceImpl extends ServiceImpl<DeviceUplinkDataMapper, DeviceUplinkData> implements IDeviceUplinkDataService {

}

