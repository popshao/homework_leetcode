package com.homework.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * 微信服务接口
 * 
 * @Author: lei.zhang
 * @Email: lei.zhang@rograndec.com
 * @CreateDate: 2019/5/17
 * @Version: 1.0
 */
public class WeixinUtil {

    // 微信公众账号或开放平台服务号APP的唯一标识
    private final static String SERVICE_APP_ID = "wxbc56cef535b95422";

    // APPID服务号对应的接口密码
    private final static String SERVICE_APP_SECRET = "5b2d7c9e248b1d9c4b3621e343cf1e60";

    public static void main(String[] args) throws Exception {
        WeixinUtil util = new WeixinUtil();
        String token = util.getAccessToken();
        String cardId = util.createCard(token);
        util.sendCardToCustomer(token, cardId);
    }
    
    /*
     * 获取调用接口凭证access_token
     * 
     * @return access_token
     */
    public String getAccessToken()
            throws Exception {
        StringBuilder requestUrl = new StringBuilder();
        requestUrl.append("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=");
        requestUrl.append(SERVICE_APP_ID);
        requestUrl.append("&secret=");
        requestUrl.append(SERVICE_APP_SECRET);
        String responseJson = HttpsClientUtil.sendGet(requestUrl.toString());
        JSONObject jsonObject = JSON.parseObject(responseJson);

        return jsonObject.getString("access_token");
    }

    /**
     * 创建卡劵信息
     * 
     * @return
     * @author lei.zhang
     * @date 2019/5/17
     */
    public String createCard(String accessTokean) {
        CreateCartVO vo = new CreateCartVO();
        vo.setCard_type("MEETING_TICKET");
        BoardingCardVO cardDetail = new BoardingCardVO();
        cardDetail.setMeeting_detail("本次班车于2019年5月10号在南门出发，出发时间：14:00。");
        vo.setMeeting_ticket(cardDetail);
        Map<String, Object> map = new HashMap<>();
        map.put("card", vo);
        String requestJson = JSONObject.toJSONString(map);
        System.out.println(requestJson);
        String responseJson = HttpsClientUtil.sendPost("https://api.weixin.qq.com/card/create?access_token=" + accessTokean, requestJson);
        System.out.println(responseJson);
        JSONObject jsonObject = JSON.parseObject(responseJson);
        
        System.out.println(jsonObject.toJSONString());
        return jsonObject.getString("card_id");
    }
    
    /**
     * 更新卡劵信息
     * 
     * @return
     * @author lei.zhang
     * @date 2019/5/17
     */
    public String updateCard(String accessTokean) {
        UpdateCartVO vo = new UpdateCartVO();
        vo.setCode("1231123");
        vo.setCard_id("pTyaJw1ZvbLNDxw9K5vrIgCGzR5w");
        vo.setEtkt_bnr("1234567");
        vo.setQrcode_data("www.baidu.com");
        
        String requestJson = JSONObject.toJSONString(vo);
        String responseJson = HttpsClientUtil.sendPost("https://api.weixin.qq.com/card/boardingpass/checkin?access_token=" + accessTokean, requestJson);
        JSONObject jsonObject = JSON.parseObject(responseJson);
        
        System.out.println(jsonObject.toJSONString());
        return jsonObject.getString("card_id");
    }
    
    /**
     * 投递卡劵
     * 
     * @return
     * @author lei.zhang
     * @date 2019/5/17
     */
    public void sendCardToCustomer(String accessTokean, String cardId) {
        SendCartVO sendCartVO = new SendCartVO();
        sendCartVO.setCardId(cardId);
        List<String> list = new ArrayList<>();
        list.add("oTyaJw5SDv4kvBV6ybmetKRhJ8-I");
        list.add("oTyaJwwMgoB0c0-3CQPtxiLY_0_4");
        sendCartVO.setTouser(list);
        
        
        String requestJson = JSONObject.toJSONString(sendCartVO);
        String responseJson = HttpsClientUtil.sendPost("https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=" + accessTokean, requestJson);
        JSONObject jsonObject = JSON.parseObject(responseJson);
        
        System.out.println(jsonObject.toJSONString());
    }

    public void getOpenIdList(String accessToken) {
        
        String responseJson = HttpsClientUtil.sendGet("https://api.weixin.qq.com/cgi-bin/user/get?access_token=" +  accessToken);
        JSONObject jsonObject = JSON.parseObject(responseJson);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray jsonArray = data.getJSONArray("openid");
        for (int i = 0; i < jsonArray.size(); i++) {
            try {
                System.out.println(jsonArray.getString(i));
                getUserInfoByOpenId(accessToken, jsonArray.getString(i));
            } catch (Exception e) {
                break;
            }
        }
    }
    
    /*
     * 获取用户在商户appid下的唯一标识
     */
    public void getUserInfoByOpenId(String accessToken, String openId)
            throws Exception {
        StringBuilder requestUrl = new StringBuilder();
        requestUrl.append("https://api.weixin.qq.com/cgi-bin/user/info?access_token="+accessToken+"&openid=" + openId + "&lang=zh_CN");

        // http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html
        String responseJson = HttpsClientUtil.sendGet(requestUrl.toString());
        JSONObject jsonObject = JSON.parseObject(responseJson);
        System.out.println(openId + "----------->" + jsonObject.getString("nickname"));
    }
    
    
}
