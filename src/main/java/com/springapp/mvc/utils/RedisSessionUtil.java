package com.springapp.mvc.utils;

import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017-09-28 0028.
 */
public class RedisSessionUtil {
    private static Jedis jedis;
    //默认session缓存生存时间,以秒为单位
    private static final int expire = 180;
    static {
        jedis = new Jedis("192.168.31.17");
    }

    public static Jedis getJedis(){
        if (jedis != null){
            return jedis;
        }else{
            return new Jedis("192.168.31.17");
        }

    }

    /**
     * 往redis的session里增添新内容
     * @param sessionId
     * @param key
     * @param value
     */
    public static void putSessionValue(String sessionId,String key,String value){
        if(sessionId!=null&&!sessionId.equals("")){
            //如果原来已有数据，则在原来的JSONObject的基础上增加用户态属性的键值
            if(jedis.exists(sessionId)){
                String jsonStr=jedis.get(sessionId);
                JSONObject jsonObj=JSONObject.fromObject(jsonStr);
                jsonObj.put(key, value);
                jedis.set(sessionId, jsonObj.toString());
                //设置jedis该键session的过期时间
                jedis.expire(key, expire);
            }
            //否则在redis里新增一个session
            else{
                JSONObject jsonObj=new JSONObject();
                jsonObj.put(key, value);
                jedis.set(sessionId, jsonObj.toString());
                jedis.expire(key,expire);
                System.out.println(sessionId+"------------------------保存:"+value);
                //7016E97CC56D31294C04D63D50189256  09F93C206B449ABE6405E2D852505038
            }
        }
    }

    /**
     * 从redis的session里获得属性
     * @param sessionId
     * @param key
     * @return
     */
    public static Object getSessionValue(String sessionId,String key){
        if(sessionId!=null&&!sessionId.equals("")&&jedis.exists(sessionId)){
            //根据sessionId活动了session的json对象后再进行操作
            String jsonStr=jedis.get(sessionId);
            JSONObject jsonObj=JSONObject.fromObject(jsonStr);
            return jsonObj.get(key);
        }
        return null;
    }

    /**
     * 从redis删除session
     * @param sessionId
     * @return
     */
    public void removeSession(String sessionId){
        jedis.del(sessionId);
    }

    /**
     * 是否存在改session
     * @param sessionId
     * @return
     */
    public static boolean isExitSession(String sessionId){
        return jedis.exists(sessionId);
    }

    /**
     * 从请求中获得客户端给的cookie中对应的sessionId
     * @return
     */
//    public String getSessionId(HttpServletRequest request){
//        String sessionId=null;
//        //获得该有效路径下的所有cookie
//        Cookie[] cookie = request.getCookies();
//        if(cookie!=null){
//            for (int i = 0; i < cookie.length; i++) {
//                Cookie cook = cookie[i];
//                //遍历cookies，找到制定cookiename的cookie,从键值对中取出sessionId
//                if(cook.getName().equals(cookname)){
//                    sessionId=cook.getValue().toString();
//                }
//            }
//        }
//        return sessionId;
//    }

    public void  test(){
        Jedis jedis = new Jedis("192.168.31.17");
        System.out.println("连接成功...");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));

        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }

        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
        List list1 = new ArrayList();
        list1.add("fdadf");

        jedis.set("user".getBytes(), SerializeUtil.serialize(list1));
//            List getUser =SerializeUtil.unserialize(jedis.get("user".getBytes()));
//            System.out.println("----------"+getUser[0]);
    }
}
