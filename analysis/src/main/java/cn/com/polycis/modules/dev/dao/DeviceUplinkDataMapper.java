package cn.com.polycis.modules.dev.dao;

import cn.com.polycis.common.requesdata.RequestVO;
import cn.com.polycis.modules.dev.entity.DataList;
import cn.com.polycis.modules.dev.entity.DeviceUplinkData;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备上行数据表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-11-30
 */
public interface DeviceUplinkDataMapper extends BaseMapper<DeviceUplinkData> {


    Integer selectDevUpDataCount(Map<String, Object> map);

    List<DataList> selectDevUpDataList(String devEUI, int datas);

    List<DeviceUplinkData> selectUpDataList(RequestVO requestVO);

    Integer selectUpDataListCount(RequestVO requestVO);

    List<DeviceUplinkData> selectUpDataListNoSuSys(RequestVO requestVO);

    Integer selectUpDataListNoSuSysCount(RequestVO requestVO);
}
