package me.chanjar.docker;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @Value("${target.host}")
    private String host;
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, String> getHealth() {
        HashMap<String, String> result = new HashMap<>();
        result.put("host", host);
        result.put("status", "ok");
        result.put("date", new Date().toString());
        return result;
    }
}
