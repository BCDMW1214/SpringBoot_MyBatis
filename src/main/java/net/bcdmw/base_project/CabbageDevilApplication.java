package net.bcdmw.base_project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.bcdmw.base_project.mapper")
public class CabbageDevilApplication  {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CabbageDevilApplication.class, args);
    }
}