package com.iran.demo.swagger.controller;

import com.iran.demo.swagger.model.User;
import com.iran.demo.swagger.service.UserService;
import com.iran.demo.swagger.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: IranLin
 * @Create Date: 2019/11/23 20:46
 * @Description：
 **/
@RestController
@RequestMapping("/users")
@Api(tags = "用户管理接口", description = "User Controller")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询单个用户
     */
    @ApiOperation(value = "根据ID获取单个用户信息", notes = "根据ID返回用户对象")
    @GetMapping("/{userId}")
    public ResponseResult getUserById(@PathVariable long userId){
        return ResponseResult.ok(userService.getUserById(userId));
    }

    /**
     * 查询多个用户
     * @return
     */
    @ApiOperation(value = "获取所有用户", notes = "返回全部用户")
    @GetMapping()
    public ResponseResult<List<User>> getUsers() {
        return ResponseResult.ok(userService.getUsers());
    }


    /**
     * 添加多个用户
     * @param users
     * @return
     */
    @ApiOperation(value = "添加多个用户", notes = "使用JSON以数组形式添加多个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "users", value = "用户JSON数组", required = true, dataType = "User",allowMultiple = true)
    })
    @PostMapping()
    public ResponseResult<String> addUsers(@RequestBody List<User> users) {
        if (userService.addUsers(users) > 0) {
            return ResponseResult.ok("users added");
        } else {
            return ResponseResult.err("ADD_USER_ERROR", "添加多个用户失败", "add exception");
        }
    }

    /**
     * 添加单个用户
     * @param user
     * @return
     */
    @PostMapping("/user")
    public ResponseResult<String> addUser(@RequestBody User user) {
        if (userService.addUser(user) > 0) {
            return ResponseResult.ok("user added");
        } else {
            return ResponseResult.err("ADD_USER_ERROR", "添加用户失败", "add exception");
        }
    }

    /**
     * 更新单个用户
     * @param user
     * @return
     */
    @PutMapping("/user")
    public ResponseResult<String> updateUser(@RequestBody User user) {
        if (userService.updateUser(user) > 0) {
            return ResponseResult.ok("user updated");
        } else {
            return ResponseResult.err("UPDATE_USER_ERROR", "更新用户失败", "update exception");
        }
    }

    /**
     * 删除单个用户
     * @param userId
     * @return
     */
    @DeleteMapping("/user")
    public ResponseResult<String> deleteUser(long userId) {
        if (userService.deleteUser(userId) > 0) {
            return ResponseResult.ok("user deleted");
        } else {
            return ResponseResult.err("DELETE_USER_ERROR", "删除用户失败", "delete exception");
        }
    }
}
