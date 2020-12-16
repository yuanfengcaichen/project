package club.codeqi.Aspect;

import club.codeqi.utils.JsonUtils;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;

public class SMS implements Serializable {
    private String phone;
    private String code;
    public static final Logger LOGGER = LoggerFactory.getLogger("SMS发送记录");
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object sendSMS(){
        Object result = null;
        try {
            int appid = 1400336700;
            String appkey = "8993880b44bfcc2b805606db6e7cc5e2";
            String[] phoneNumbers = new String[]{this.phone};
            int templateId = 559969;
            String smsSign = "祁远学习历程";
            String[] params = new String[]{this.code};
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
        return result;
    }

    @Override
    public String toString() {
        return "SMS{" +
                "phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
