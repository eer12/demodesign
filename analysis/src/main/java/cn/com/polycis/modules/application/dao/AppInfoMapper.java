package cn.com.polycis.modules.application.dao;

import cn.com.polycis.common.vo.RequestAPIVO;
import cn.com.polycis.common.vo.RequestVO;
import cn.com.polycis.modules.application.entity.AppDevVo;
import cn.com.polycis.modules.application.entity.AppInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 应用表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-11-28
 */
@Mapper
public interface AppInfoMapper extends BaseMapper<AppInfo> {

    List<AppInfo>  selectAppList(Map<String, Object> params);


    Integer selectAppListCount(Map<String, Object> params);

    AppInfo selectAppInfo(Map<String, Object> params);

    Integer deleteAppOrganizationRelation(Integer id, Integer org);

    Integer selectHttpCountByUserId(Integer id);

    Integer selectMqCountByUserId(Integer id);

    Integer insertAppOrgRe(Integer id, Integer org);

    Integer selectAppDevReCount(Integer id);


    Integer insertBachAppDevRe(Integer appId, List<Integer> list);


    Integer deleteAppDevRelation(Integer appId, Integer id);


    List<Integer> selectAllAppId();

    List<AppInfo> selectAppListNoPage(Integer userId);

    //查询组织下所有的应用id
    List<Integer> selectAppIdByorgId(Integer orgId);

    List<AppInfo> selectTotalList(HashMap<String, Object> params);

    Integer selectTotalCount(HashMap<String, Object> params);

    List<AppInfo> selectAppListForAllUser(RequestVO requestVO);

    List<AppInfo> selectForApplist(RequestVO requestVO);

    Integer selectForApplistCount(RequestVO requestVO);

    List<AppInfo> selectForAPI(RequestVO requestVO);

    Integer selectForAPICount(RequestVO requestVO);

    Integer selectAppIsUser(RequestAPIVO requestAPIVO);

    Integer selectAppIsIsUser(Integer userid, Integer appid);

    List<AppInfo> selectAppListByOrg(Integer orgId);

    AppDevVo selectappToDecTopology(Integer appId);
}
