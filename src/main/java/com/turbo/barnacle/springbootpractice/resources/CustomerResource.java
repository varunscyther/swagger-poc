package com.turbo.barnacle.springbootpractice.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/rest/customer")
@Api(value = "Customer Rest Controller", description = "REST endpoint for handling the Customer details operation")
public class CustomerResource {

    @ApiOperation(value = "Get Customer operation")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 9000, message = "Business Response Code 9000"),
                    @ApiResponse(code = 9001, message = "Business Response Code 9001"),
                    @ApiResponse(code = 9002, message = "Business Response Code 9002")
            }
    )
    @GetMapping("/get/{id}")
    public String getCustomerDetails(@PathVariable("id") final String id){
        return customerMap().get(id);
    }

    @ApiOperation(value = "Add Customer operation")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 8000, message = "Business Response Code 8000"),
                    @ApiResponse(code = 8001, message = "Business Response Code 8001"),
                    @ApiResponse(code = 8002, message = "Business Response Code 8002")
            }
    )
    @PutMapping("/add/{id}")
    public String addCustomerDetails(@PathVariable("id") final String id){
         return "Customer is added : " + id;
    }


    @ApiOperation(value = "Delete Customer operation")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 7000, message = "Business Response Code 7000"),
                    @ApiResponse(code = 7001, message = "Business Response Code 7001"),
                    @ApiResponse(code = 7002, message = "Business Response Code 7002")
            }
    )
    @DeleteMapping("/delete/{id}")
    public String deleteCustomerDetails(@PathVariable("id") final String id){
        return "Customer is deleted : " + id;
    }

    protected Map<String, String> customerMap() {

        return Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>("0", "Varun Singh"),
                new AbstractMap.SimpleEntry<>("1", "Abhishek Singha"),
                new AbstractMap.SimpleEntry<>("2", "Shobhit Garg"),
                new AbstractMap.SimpleEntry<>("3", "Shri Lakshmi"),
                new AbstractMap.SimpleEntry<>("4", "Harshit"),
                new AbstractMap.SimpleEntry<>("5", "Bhargawi"),
                new AbstractMap.SimpleEntry<>("6", "Hitesh"),
                new AbstractMap.SimpleEntry<>("7", "Narendra"),
                new AbstractMap.SimpleEntry<>("8", "Rishi"))
                .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));
    }

}
