package club.codeqi.controller;

import club.codeqi.utils.JsonUtils;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class testController {
    public static final Logger LOGGER = LoggerFactory.getLogger("Request请求记录");
    @GetMapping("/hello")
    public String test(){
        return "hello world";
    }

    @GetMapping({"/sendmsg"})
    public Map send(@RequestParam("phone") String phone, HttpSession session) {
        (new StringBuilder()).append("+86").append(phone).toString();
        String code = String.valueOf(Math.round((Math.random() + 1.0D) * 1000.0D));
        session.setAttribute("phone", phone);
        session.setAttribute("code", code);
        Object result = null;
        try {
            int appid = 1400336700;
            String appkey = "8993880b44bfcc2b805606db6e7cc5e2";
            String[] phoneNumbers = new String[]{phone};
            int templateId = 559969;
            String smsSign = "祁远学习历程";
            String[] params = new String[]{code};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult res = ssender.sendWithParam("86", phoneNumbers[0], templateId, params, smsSign, "", "");
            LOGGER.info(String.valueOf(res));
            result = res;
        } catch (HTTPException var13) {
            var13.printStackTrace();
        } catch (JSONException var14) {
            var14.printStackTrace();
        } catch (IOException var15) {
            var15.printStackTrace();
        }

        Map resultmap = new HashMap();
        resultmap.put("result", result);
        return resultmap;
    }

    @PostMapping({"/sendmsg"})
    public Map sendmsg(@RequestBody Map map) {
        String phone = (String) map.get("phone");
        String code = (String) map.get("code");
        Object result = null;
        try {
            int appid = 1400336700;
            String appkey = "8993880b44bfcc2b805606db6e7cc5e2";
            String[] phoneNumbers = new String[]{phone};
            int templateId = 559969;
            String smsSign = "祁远学习历程";
            String[] params = new String[]{code};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult res = ssender.sendWithParam("86", phoneNumbers[0], templateId, params, smsSign, "", "");
            LOGGER.info(JsonUtils.toString(res));
            result = res;
        } catch (HTTPException var13) {
            var13.printStackTrace();
        } catch (JSONException var14) {
            var14.printStackTrace();
        } catch (IOException var15) {
            var15.printStackTrace();
        }

        Map resultmap = new HashMap();
        resultmap.put("result", result);
        return resultmap;
    }
}
