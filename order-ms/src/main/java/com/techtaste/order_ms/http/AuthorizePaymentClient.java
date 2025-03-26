package com.techtaste.order_ms.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techtaste.order_ms.dto.AuthorizationDTO;


@FeignClient("payment-ms")
public interface AuthorizePaymentClient {
    
    @RequestMapping(method = RequestMethod.GET, value = "/payments/authorization/{id}")
    AuthorizationDTO getAuthorization(@PathVariable String id);
}
