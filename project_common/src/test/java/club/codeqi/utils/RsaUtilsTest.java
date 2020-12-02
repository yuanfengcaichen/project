package club.codeqi.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RsaUtilsTest {
    private String privateFilePath="E:\\ImportantPlan\\项目管理\\project\\gengerateKey\\id_key_rsa";
    private String publicFilePath="E:\\ImportantPlan\\项目管理\\project\\gengerateKey\\id_key_rsa.pub";

    @Test
    void generateKey() throws Exception {
        RsaUtils.generateKey(publicFilePath,privateFilePath,"codeqi",2048);
    }

    @Test
    void getPublicKey() throws Exception {
        System.out.println(RsaUtils.getPublicKey(publicFilePath));
    }

    @Test
    void getPrivateKey() throws Exception {
        System.out.println(RsaUtils.getPrivateKey(privateFilePath));
    }


}