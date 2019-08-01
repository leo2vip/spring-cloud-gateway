package com.example.demo.hystrix;

import com.jsqx.common.web.responsewrapper.ResultJSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qutf
 * @Date 2019/7/31 10:03
 *  熔断降级
 **/
@RestController
public class HystrixFallbackController {

    /**
     * 统一熔断降级
     * @return 统一返回500，服务器异常
     */
    @RequestMapping(value = "/defaultFallback")
    public ResultJSON defaultFallback(){
        ResultJSON resultJSON = new ResultJSON();
        resultJSON.setCode("500");
        resultJSON.setMessage("服务器异常！");
        return resultJSON;
    }
}

