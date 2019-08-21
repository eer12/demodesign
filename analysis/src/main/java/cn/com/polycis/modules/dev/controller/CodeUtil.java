package cn.com.polycis.modules.dev.controller;

import cn.com.polycis.common.utils.R;

public class CodeUtil {
    public static final String NOT_PERMISSION = "用户无此类操作权限,请授权";
    public static final String ERROR = "系统异常,请联系管理员";
    public static R addR(int code){
        R r = new R();
        switch (code){
            case 200:
                r.put("code", code);
                r.put("msg", "设备创建成功");
                return r;
            case 0:
                r.put("code", code);
                r.put("msg", "设备创建失败,参数错误");
                return r;
            case 401:
                r.put("code", code);
                r.put("msg", NOT_PERMISSION);
                return r;
            case 403:
                r.put("code", code);
                r.put("msg", "设备激活参数有误,请检查参数");
                return r;
            default:
                r.put("code", 500);
                r.put("msg", ERROR);
                return r;
        }
    }
    public static R updateR(int code) {
        R r = new R();
        switch (code) {
            case 200:
                r.put("code", code);
                r.put("msg", "设备修改成功");
                return r;
            case 0:
                r.put("code", code);
                r.put("msg", "设备修改失败");
                return r;
            case 401:
                r.put("code", code);
                r.put("msg", NOT_PERMISSION);
                return r;
            default:
                r.put("code", 500);
                r.put("msg", ERROR);
                return r;
        }
    }
    public static R deleteR(int code){
        R r = new R();
        switch (code) {
            case 200:
                r.put("code", code);
                r.put("msg", "设备删除成功");
                return r;
            case 0:
                r.put("code", code);
                r.put("msg", "设备删除失败");
                return r;
            case 401:
                r.put("code", code);
                r.put("msg", NOT_PERMISSION);
                return r;
            default:
                r.put("code", 500);
                r.put("msg", ERROR);
                return r;
        }
    }

    public static R deleProR(int code){
        R r = new R();
        switch (code){
            case 200:
                r.put("code", code);
                r.put("msg", "设备配置文件删除成功");
                return r;
            case 0:
                r.put("code", code);
                r.put("msg", "设备配置文件删除失败");
                return r;
            case 401:
                r.put("code", code);
                r.put("msg", NOT_PERMISSION);
                return r;
            case 403:
                r.put("code", code);
                r.put("msg", "此配置文件下已有设备,请先删除原有设备");
                return r;
            default:
                r.put("code", 500);
                r.put("msg", ERROR);
                return r;
        }
    }
    public static R addGate(int code){
        R r = new R();
        switch (code){
            case 200:
                r.put("code", code);
                r.put("msg", "网关添加成功");
                return r;
            case 0:
                r.put("code", code);
                r.put("msg", "网关添加失败");
                return r;
            case 401:
                r.put("code", code);
                r.put("msg", NOT_PERMISSION);
                return r;
            default:
                r.put("code", 500);
                r.put("msg", ERROR);
                return r;
        }
    }

    public static R deleteGate(int code){
        R r = new R();
        switch (code){
            case 200:
                r.put("code", code);
                r.put("msg", "网关删除成功");
                return r;
            case 0:
                r.put("code", code);
                r.put("msg", "网关删除失败");
                return r;
            case 401:
                r.put("code", code);
                r.put("msg", NOT_PERMISSION);
                return r;
            default:
                r.put("code", 500);
                r.put("msg", ERROR);
                return r;
        }
    }

    public static R updateGate(int code){
        R r = new R();
        switch (code){
            case 200:
                r.put("code", code);
                r.put("msg", "网关更新成功");
                return r;
            case 0:
                r.put("code", code);
                r.put("msg", "网关更新失败");
                return r;
            case 401:
                r.put("code", code);
                r.put("msg", NOT_PERMISSION);
                return r;
            default:
                r.put("code", 500);
                r.put("msg", ERROR);
                return r;
        }
    }

    public static R deleteGatePro(int code){
        R r = new R();
        switch (code){
            case 200:
                r.put("code", code);
                r.put("msg", "网关配置文件删除成功");
                return r;
            case 0:
                r.put("code", code);
                r.put("msg", "网关配置文件删除失败");
                return r;
            case 401:
                r.put("code", code);
                r.put("msg", NOT_PERMISSION);
                return r;
            case 403:
                r.put("code", code);
                r.put("msg", "网关配置文件已绑定网关,请先解绑");
                return r;
            default:
                r.put("code", 500);
                r.put("msg", ERROR);
                return r;
        }
    }

    public static R addGatePro(int code){
        R r = new R();
        switch (code){
            case 200:
                r.put("code", code);
                r.put("msg", "网关配置文件添加成功");
                return r;
            case 0:
                r.put("code", code);
                r.put("msg", "网关配置文件添加失败");
                return r;
            case 401:
                r.put("code", code);
                r.put("msg", NOT_PERMISSION);
                return r;
            default:
                r.put("code", 500);
                r.put("msg", ERROR);
                return r;
        }
    }

}
