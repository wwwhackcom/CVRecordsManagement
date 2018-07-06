package com.wwwhackcom.mapper;
import java.util.*;
import com.wwwhackcom.model.JobType;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;

public interface JobTypeMapper{

	@Select("SELECT COUNT(*) FROM JobType ")
	Integer count();


	@Select("SELECT * FROM JobType WHERE ID = #{ID} LIMIT 1 ")
	@Results({
			@Result(property="iD",column="ID")
			,@Result(property="name",column="Name")
	})
	JobType getByID(@Param("ID") Integer ID);


	@Delete("DELETE FROM JobType WHERE ID = #{ID} ")
	Integer deleteByID(@Param("ID") Integer ID);

	@Update({
		"UPDATE JobType SET ID=#{iD}, Name=#{name} where ID = #{ID}"
	})
	Integer update(JobType jobType);

	@Insert({
		"INSERT IGNORE INTO JobType (`ID`, `Name`) VALUE (#{iD}, #{name})"
	})
	Integer save(JobType jobType);


	@Select("SELECT * FROM JobType LIMIT 10 ")
@Results({
	@Result(property="iD",column="ID")
	,@Result(property="name",column="Name")
})
	List<JobType> list();


	@Select("SELECT * FROM JobType LIMIT #{start}, #{step}")
@Results({
	@Result(property="iD",column="ID")
	,@Result(property="name",column="Name")
})
	List<JobType> page(@Param("start") int start, @Param("step") int step );
	
}