package cn.com.polycis.modules.application.service.impl;


import cn.com.polycis.common.vo.PageInfoVO;
import cn.com.polycis.common.vo.RequestAPIVO;
import cn.com.polycis.common.vo.RequestVO;
import cn.com.polycis.modules.application.dao.AppInfoMapper;
import cn.com.polycis.modules.application.dao.HttpInfoMapper;
import cn.com.polycis.modules.application.dao.MqInfoMapper;
import cn.com.polycis.modules.application.entity.AppDevVo;
import cn.com.polycis.modules.application.entity.AppInfo;
import cn.com.polycis.modules.application.entity.HttpInfo;
import cn.com.polycis.modules.application.entity.MqInfo;
import cn.com.polycis.modules.application.service.IAppInfoService;
import cn.com.polycis.modules.application.service.IMqInfoService;
import cn.com.polycis.modules.dev.dao.DeviceInfoMapper;
import cn.com.polycis.modules.dev.entity.DeviceInfo;
import cn.com.polycis.modules.dev.service.IDeviceInfoService;
import cn.com.polycis.modules.user.entity.Users;
import cn.com.polycis.modules.user.service.IUsersService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;
import java.util.*;

import static cn.com.polycis.common.mqtts.RabbitMQUtilForApp.initFactory;
import static cn.com.polycis.common.utils.FinalCode.ROLE_SUSYS;

/**
 * <p>
 * 应用表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-11-28
 */
@Service
@Transactional
@PropertySource("classpath:application.properties")
public class AppInfoServiceImpl extends ServiceImpl<AppInfoMapper, AppInfo> implements IAppInfoService {



}
