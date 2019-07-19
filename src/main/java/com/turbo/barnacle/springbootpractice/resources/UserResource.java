package com.turbo.barnacle.springbootpractice.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/rest/user")
@Api(value = "User Rest Controller", description = "REST endpoint for handling the User details operation")
public class UserResource {

    @ApiOperation(value = "Get User operation")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 6000, message = "Business Response Code 6000"),
                    @ApiResponse(code = 6001, message = "Business Response Code 6001"),
                    @ApiResponse(code = 6002, message = "Business Response Code 6002")
            }
    )
    @GetMapping("/get/{id}")
    public String getUserDetails(@PathVariable("id") final String id){
        return userMap().get(id);
    }

    @ApiOperation(value = "Add User operation")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 5000, message = "Business Response Code 5000"),
                    @ApiResponse(code = 5001, message = "Business Response Code 5001"),
                    @ApiResponse(code = 5002, message = "Business Response Code 5002")
            }
    )
    @PutMapping("/add/{id}")
    public String addUserDetails(@PathVariable("id") final String id){
        return "User is added " + id;
    }

    @ApiOperation(value = "Delete User operation")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 4000, message = "Business Response Code 4000"),
                    @ApiResponse(code = 4001, message = "Business Response Code 4001"),
                    @ApiResponse(code = 4002, message = "Business Response Code 4002")
            }
    )
    @DeleteMapping("/delete/{id}")
    public String deleteUserDetails(@PathVariable("id") final String id){
        return "User is deleted " + id;
    }

    protected static Map<String, String> userMap() {

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
