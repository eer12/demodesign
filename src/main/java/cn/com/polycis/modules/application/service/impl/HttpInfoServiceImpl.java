package cn.com.polycis.modules.application.service.impl;

import cn.com.polycis.common.vo.RequestAPIVO;
import cn.com.polycis.modules.application.dao.HttpInfoMapper;
import cn.com.polycis.modules.application.entity.AppHttpVO;
import cn.com.polycis.modules.application.entity.HttpInfo;
import cn.com.polycis.modules.application.service.IHttpInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 应用的http信息表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-03
 */
@Service
public class HttpInfoServiceImpl extends ServiceImpl<HttpInfoMapper, HttpInfo> implements IHttpInfoService {




}
