package com.finhub.prototype.service;

import com.finhub.prototype.service.TenantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MyServiceTest {

    @Autowired
    private TenantService myService;

    @Test
    void testServiceLogic() {
        int result = myService.getAllTenants().size();
        assertEquals(1, result);
    }
}
