package cn.com.polycis.modules.application.dao;

import cn.com.polycis.modules.application.entity.AppMqVO;
import cn.com.polycis.modules.application.entity.MqInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * mq信息表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-03
 */
public interface MqInfoMapper extends BaseMapper<MqInfo> {




    List<AppMqVO> selectAppVOList(Map<String, Object> param);

    Integer selectAppVOListCount(Map<String, Object> param);
}
