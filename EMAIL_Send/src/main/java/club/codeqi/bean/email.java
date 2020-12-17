package club.codeqi.bean;

import cn.hutool.extra.mail.MailUtil;

import java.util.List;

public class email {
    private String subject;
    private String bodyPreview;
    private String emailAddress;
    public void sendEmail(){
        //MailUtil.send(this.emailAddress, this.subject, this.bodyPreview, false);
        MailUtil.send("y1464349104@outlook.com", "测试", "邮件来自Hutool测试", false);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBodyPreview() {
        return bodyPreview;
    }

    public void setBodyPreview(String bodyPreview) {
        this.bodyPreview = bodyPreview;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "email{" +
                "subject='" + subject + '\'' +
                ", bodyPreview='" + bodyPreview + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
