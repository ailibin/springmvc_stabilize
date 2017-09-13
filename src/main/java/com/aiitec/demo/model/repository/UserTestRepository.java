package com.aiitec.demo.model.repository;


import com.aiitec.demo.model.entity.UserTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * 该类用来测试注册登陆功能操作数据库
 */
@Repository
public interface UserTestRepository extends JpaRepository<UserTestEntity, Integer> {
    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update UserTestEntity us set us.username=:qUsername,us.email=:qEmail, us.password=:qPassword where us.id=:qId")
    public void updateUserData(@Param("qUsername") String username, @Param("qEmail") String email, @Param("qPassword") String password, @Param("qId") Integer id);
}
