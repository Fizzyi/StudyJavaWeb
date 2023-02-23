package com.springboot.chapter15.controller;

import com.springboot.chapter15.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService = null;

    @PostMapping("/purchase")
    public Result purchase(Long userId, Long productId, Integer quantity){
        boolean success = purchaseService.purchase(userId,productId,quantity);
        String message = success? "抢购成功":"抢购失败";
        return new Result(success,message);
    }

    //响应结果
    class Result{
        private boolean success = false;
        private String message = null;

        public Result(){}
        private Result(Boolean success,String message){
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
