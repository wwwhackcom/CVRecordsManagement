package com.wwwhackcom.mapper;
import java.util.*;
import com.wwwhackcom.model.UserProfile;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;

public interface UserProfileMapper{

	@Select("SELECT COUNT(*) FROM UserProfile ")
	Integer count();


	@Select("SELECT * FROM UserProfile WHERE ID = #{ID} LIMIT 1 ")
	@Results({
			@Result(property="iD",column="ID")
			,@Result(property="userID",column="UserID")
			,@Result(property="gender",column="Gender")
			,@Result(property="dOB",column="DOB")
	})
	UserProfile getByID(@Param("ID") Integer ID);


	@Delete("DELETE FROM UserProfile WHERE ID = #{ID} ")
	Integer deleteByID(@Param("ID") Integer ID);

	@Update({
		"UPDATE UserProfile SET UserID=#{userID}, Gender=#{gender}, DOB=#{dOB} where ID = #{ID}"
	})
	Integer update(UserProfile userProfile);

	@Insert({
		"INSERT IGNORE INTO UserProfile (`UserID`, `Gender`, `DOB`) VALUE (#{userID}, #{gender}, #{dOB})"
	})
	Integer save(UserProfile userProfile);


	@Select("SELECT * FROM UserProfile LIMIT 10 ")
@Results({
	@Result(property="iD",column="ID")
	,@Result(property="userID",column="UserID")
	,@Result(property="gender",column="Gender")
	,@Result(property="dOB",column="DOB")
})
	List<UserProfile> list();


	@Select("SELECT * FROM UserProfile LIMIT #{start}, #{step}")
@Results({
	@Result(property="iD",column="ID")
	,@Result(property="userID",column="UserID")
	,@Result(property="gender",column="Gender")
	,@Result(property="dOB",column="DOB")
})
	List<UserProfile> page(@Param("start") int start, @Param("step") int step );
	
}