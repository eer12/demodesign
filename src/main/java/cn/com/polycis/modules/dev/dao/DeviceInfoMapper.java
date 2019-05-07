package cn.com.polycis.modules.dev.dao;

import cn.com.polycis.modules.dev.entity.DeviceInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 设备表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-11-30
 */
public interface DeviceInfoMapper extends BaseMapper<DeviceInfo> {

    int selectDevNumByAppId(List<Integer> list);
}
