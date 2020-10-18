package com.global.coffeeshop.controller;

import com.global.coffeeshop.controller.dto.request.CoffeeOrderDto;
import com.global.coffeeshop.controller.dto.response.CoffeeOrderCreatedDto;
import com.global.coffeeshop.controller.dto.response.OrderDto;
import com.global.coffeeshop.exception.CoffeeShopCustomException;
import com.global.coffeeshop.service.CoffeeOrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/order")
@Api(tags = {"order-management"})
public class OrderController {

    @Autowired
    private CoffeeOrderService coffeeOrderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoffeeOrderCreatedDto> createOrder(@RequestBody CoffeeOrderDto coffeeOrderDto, HttpServletRequest request) throws CoffeeShopCustomException {
        CoffeeOrderCreatedDto order = coffeeOrderService.createCoffeeOrder(coffeeOrderDto);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{order-id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> getOrderByOrderId(@PathVariable(name = "order-id") Long orderId, HttpServletRequest request) throws CoffeeShopCustomException {
        OrderDto order = coffeeOrderService.getOrderByOrderId(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/{order-id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> updateOrderByOrderId(@PathVariable(name = "order-id") Long orderId, @RequestBody CoffeeOrderDto coffeeOrderDto, HttpServletRequest request) throws CoffeeShopCustomException {
        CoffeeOrderCreatedDto order = coffeeOrderService.updateCoffeeOrder(coffeeOrderDto, orderId);
        return new ResponseEntity(order,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/{order-id}")
    public ResponseEntity deleteOrder(@PathVariable (name = "order-id") Long orderId, HttpServletRequest request) throws CoffeeShopCustomException {
        coffeeOrderService.deleteOrder(orderId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllOrders(HttpServletRequest request){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}