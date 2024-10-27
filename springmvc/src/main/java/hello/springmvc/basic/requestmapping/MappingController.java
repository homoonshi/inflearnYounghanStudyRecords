package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/hello-basic", "/hello-go"})
    public String helloBasic(){
        log.info("basic");
        return "ok";
    }

    /*
        PathVariable 사용
        /mapping/("userId")
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){

        log.info("mappingPath userId={}",data);
        return "ok";

    }

    @GetMapping("/mapping/{userId}/order/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){

        log.info("mappingPath userId={}, orderId={}",userId, orderId);
        return "ok";

    }

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam(){

        log.info("mappingParam");
        return "ok";

    }

    @GetMapping(value = "/mapping-header", params = "mode=debug")
    public String mappingHeader(){

        log.info("mappingHeader");
        return "ok";

    }

    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes(){

        log.info("mappingConsumes");
        return "ok";

    }

    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces(){

        log.info("mappingProduces");
        return "ok";

    }


}
