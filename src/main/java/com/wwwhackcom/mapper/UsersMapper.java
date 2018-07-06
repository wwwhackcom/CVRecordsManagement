package com.wwwhackcom.mapper;
import java.util.*;
import com.wwwhackcom.model.Users;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;

public interface UsersMapper{

	@Select("SELECT COUNT(*) FROM Users ")
	Integer count();


	@Select("SELECT * FROM Users WHERE ID = #{ID} LIMIT 1 ")
	@Results({
			@Result(property="iD",column="ID")
			,@Result(property="username",column="Username")
			,@Result(property="password",column="Password")
			,@Result(property="email",column="Email")
			,@Result(property="contact",column="Contact")
	})
	Users getByID(@Param("ID") Integer ID);


	@Delete("DELETE FROM Users WHERE ID = #{ID} ")
	Integer deleteByID(@Param("ID") Integer ID);

	@Update({
		"UPDATE Users SET Username=#{username}, Password=#{password}, Email=#{email}, Contact=#{contact} where ID = #{ID}"
	})
	Integer update(Users users);

	@Insert({
		"INSERT IGNORE INTO Users (`Username`, `Password`, `Email`, `Contact`) VALUE (#{username}, #{password}, #{email}, #{contact})"
	})
	Integer save(Users users);


	@Select("SELECT * FROM Users LIMIT 10 ")
@Results({
	@Result(property="iD",column="ID")
	,@Result(property="username",column="Username")
	,@Result(property="password",column="Password")
	,@Result(property="email",column="Email")
	,@Result(property="contact",column="Contact")
})
	List<Users> list();


	@Select("SELECT * FROM Users LIMIT #{start}, #{step}")
@Results({
	@Result(property="iD",column="ID")
	,@Result(property="username",column="Username")
	,@Result(property="password",column="Password")
	,@Result(property="email",column="Email")
	,@Result(property="contact",column="Contact")
})
	List<Users> page(@Param("start") int start, @Param("step") int step );
	
}