package com.cwjy.bs;

import com.cwjy.bs.server.CommodityServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BsApplicationTests {

    @Autowired
    private CommodityServer commodityServer;

    @Test
    void contextLoads() {
        commodityServer.selectByPrimaryKey("1");
    }

}
