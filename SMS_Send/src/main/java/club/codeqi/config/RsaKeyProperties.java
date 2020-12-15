package club.codeqi.config;

import club.codeqi.utils.RsaUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.PublicKey;

@Component
@ConfigurationProperties(prefix="rsa.key")
public class RsaKeyProperties {

    private String pubKeyFile;

    private PublicKey publicKey;

    @PostConstruct
    public void init() throws Exception {
        publicKey = RsaUtils.getPublicKey(pubKeyFile);
    }

    public String getPubKeyFile() {
        return pubKeyFile;
    }

    public void setPubKeyFile(String pubKeyFile) {
        this.pubKeyFile = pubKeyFile;
    }


    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

}
