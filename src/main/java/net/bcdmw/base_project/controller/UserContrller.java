package net.bcdmw.base_project.controller;

import net.bcdmw.base_project.domain.JsonData;
import net.bcdmw.base_project.domain.User;
import net.bcdmw.base_project.mapper.UserMapper;
import net.bcdmw.base_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/user")
public class UserContrller {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("add")
    public Object UserAdd(){
        User user=new User();
        user.setAge(22);
        user.setCreateTime(new Date());
        user.setName("caicai");
        user.setPhone("1597719");
        int id=userMapper.insert(user);
        return JsonData.buildSuccess(id);
    }

    @GetMapping("findAll")
    public Object findAll(){
        return JsonData.buildSuccess(userMapper.getAll());
    }
    @GetMapping("findById")
    public Object findById(long id){
        return JsonData.buildSuccess(userMapper.findById(id));
    }
    @GetMapping("up_by_id")
    public Object upById(long id,String name){
        User user=new User();
        user.setName(name);
        return JsonData.buildSuccess();
    }
	@GetMapping("del_by_id")
	public Object delById(long id){
	userMapper.delete(id);
       return JsonData.buildSuccess();
	}


/*    @GetMapping("transac")
    public Object transac(){
        int id=userService.addAccount();
        return JsonData.buildSuccess(id);
    }*/

}
