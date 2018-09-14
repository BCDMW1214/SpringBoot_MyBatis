package net.bcdmw.base_project.mapper;



import net.bcdmw.base_project.domain.User;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description：访问数据库的接口
 * @Date: 2018/9/12
 * @Author: 白菜大魔王
 */
public interface UserMapper {

	/**
	 * @Description:插入
	 * @Param: [user]
	 * @return: int
	 * @Author: 白菜大魔王
	 * @Date: 2018/9/12
	 */
	//推荐使用#{}取值，不要用${},因为存在注入的风险
	 @Insert("INSERT INTO user(name,phone,create_time,age) VALUES(#{name}, #{phone}, #{createTime},#{age})")
	 @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")   //keyProperty java对象的属性；keyColumn表示数据库的字段

	 int insert(User user);

	/**
	 * @Description: 查询全部
	 * @Param: null
	 * @return: User
	 * @Author: 白菜大魔王
	 * @Date: 2018/9/12
	 */
    @Select("SELECT * FROM user")
    @Results({
        @Result(column = "create_time",property = "createTime")  //javaType = java.util.Date.class
    })
    List<User> getAll();


	/**
	 * @Description:ID查找
	 * @Param: [user]
	 * @return: User
	 * @Author: 白菜大魔王
	 * @Date: 2018/9/12
	 */
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
    	 @Result(column = "create_time",property = "createTime")
    })
		User findById(Long id);


	/**
	 * @Description:ID更新
	 * @Param: [user]
	 * @return: void
	 * @Author: 白菜大魔王
	 * @Date: 2018/9/12
	 */
    @Update("UPDATE user SET name=#{name} WHERE id =#{id}")

    void update(User user);
	/**
	 * @Description:ID删除
	 * @Param: [userId]
	 * @return: void
	 * @Author: 白菜大魔王
	 * @Date: 2018/9/12
	 */
    @Delete("DELETE FROM user WHERE id =#{userId}")
    void delete(Long userId);

}