package pl.kasiaak.spring_boot_learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kasiaak.spring_boot_learning.entity.Player;

@RestController
public class TestController {

    @GetMapping("/test")
    public Player test() {
        Player player = new Player();
       // player.setId(Long.valueOf(1));
        player.setName("Kasiak");
        return player;
    }
}
