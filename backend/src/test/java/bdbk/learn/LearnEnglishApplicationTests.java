package bdbk.learn;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.*;


@SpringBootTest
class LearnEnglishApplicationTests {

    @Test
    void test() throws Exception{
        ClassPathResource classPathResource = new ClassPathResource("txt/6.txt");
        InputStream is = classPathResource.getInputStream();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is));
        String str;
        while (true) {
            str = reader.readLine();
            if(str!=null)
                System.out.println(str);
            else
                break;
        }

        is.close();

    }

    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
