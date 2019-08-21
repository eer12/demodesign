package cn.com.polycis.modules.application.service.impl;

import cn.com.polycis.common.vo.RequestAPIVO;
import cn.com.polycis.modules.application.dao.MqInfoMapper;
import cn.com.polycis.modules.application.entity.AppMqVO;
import cn.com.polycis.modules.application.entity.MqInfo;
import cn.com.polycis.modules.application.service.IMqInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.com.polycis.common.mqtts.RabbitMQUtilForApp.initFactory;

/**
 * <p>
 * mq信息表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-03
 */
@Service
public class MqInfoServiceImpl extends ServiceImpl<MqInfoMapper, MqInfo> implements IMqInfoService {


}
