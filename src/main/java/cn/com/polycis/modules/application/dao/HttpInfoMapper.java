package cn.com.polycis.modules.application.dao;

import cn.com.polycis.modules.application.entity.AppHttpVO;
import cn.com.polycis.modules.application.entity.HttpInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 应用的http信息表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-03
 */
public interface HttpInfoMapper extends BaseMapper<HttpInfo> {

    List<HttpInfo> selectHttpInfoList(Map<String, Object> params);





}
