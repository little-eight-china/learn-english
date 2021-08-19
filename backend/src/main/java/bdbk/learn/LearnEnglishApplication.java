package bdbk.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("bdbk.learn.mapper")
public class LearnEnglishApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnEnglishApplication.class, args);
    }

}
