package cn.it.lvz.controller;

import cn.it.lvz.repository.ESDao;
import cn.it.lvz.entity.ElasticEntity;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/es")
public class ElasticSearchController {

    @Autowired
    private ESDao er;

    //增加
    @RequestMapping("/add/{id}")
    public String add(@PathVariable("id")String id){

        ElasticEntity employee=new ElasticEntity();
        employee.setId(id);
        employee.setName("Y.S.K");
        employee.setContent("ooo");
        employee.setPrice("26");
        er.save(employee);

        System.err.println("add a obj");
        return "success";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(){
        ElasticEntity employee=new ElasticEntity();
        employee.setId("1");
        er.delete(employee);

        return "success";
    }

    //局部更新
    @RequestMapping("/update")
    public String update(){

        ElasticEntity employee=er.queryEmployeeById("1");
        employee.setName("哈哈");
        er.save(employee);

        System.err.println("update a obj");

        return "success";
    }

    //查询
    @RequestMapping("/query/{id}")
    public ElasticEntity query(@PathVariable("id")String id){
        ElasticEntity accountInfo=er.queryEmployeeById(id);
        System.err.println(new Gson().toJson(accountInfo));

        return accountInfo;
    }

}


