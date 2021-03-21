package pl.kasiaak.spring_boot_learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public TestData test() {
        TestData testData = new TestData();
        testData.setName("Kasiak");
        return testData;
    }
}
