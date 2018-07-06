package com.wwwhackcom.mapper;
import java.util.*;
import com.wwwhackcom.model.Jobs;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;

public interface JobsMapper{

	@Select("SELECT COUNT(*) FROM Jobs ")
	Integer count();


	@Select("SELECT * FROM Jobs WHERE ID = #{ID} LIMIT 1 ")
	@Results({
			@Result(property="iD",column="ID")
			,@Result(property="companyID",column="CompanyID")
			,@Result(property="jobTitle",column="JobTitle")
			,@Result(property="jobDescription",column="JobDescription")
			,@Result(property="jobRequirement",column="JobRequirement")
			,@Result(property="jobType",column="JobType")
			,@Result(property="jobCIty",column="JobCIty")
			,@Result(property="jobSuburb",column="JobSuburb")
			,@Result(property="jobAddress",column="JobAddress")
			,@Result(property="publishDate",column="PublishDate")
			,@Result(property="contactPerson",column="ContactPerson")
			,@Result(property="phone",column="Phone")
			,@Result(property="jobLink",column="JobLink")
	})
	Jobs getByID(@Param("ID") Integer ID);


	@Delete("DELETE FROM Jobs WHERE ID = #{ID} ")
	Integer deleteByID(@Param("ID") Integer ID);

	@Update({
		"UPDATE Jobs SET CompanyID=#{companyID}, JobTitle=#{jobTitle}, JobDescription=#{jobDescription}, JobRequirement=#{jobRequirement}, JobType=#{jobType}, JobCIty=#{jobCIty}, JobSuburb=#{jobSuburb}, JobAddress=#{jobAddress}, PublishDate=#{publishDate}, ContactPerson=#{contactPerson}, Phone=#{phone}, JobLink=#{jobLink} where ID = #{ID}"
	})
	Integer update(Jobs jobs);

	@Insert({
		"INSERT IGNORE INTO Jobs (`CompanyID`, `JobTitle`, `JobDescription`, `JobRequirement`, `JobType`, `JobCIty`, `JobSuburb`, `JobAddress`, `PublishDate`, `ContactPerson`, `Phone`, `JobLink`) VALUE (#{companyID}, #{jobTitle}, #{jobDescription}, #{jobRequirement}, #{jobType}, #{jobCIty}, #{jobSuburb}, #{jobAddress}, #{publishDate}, #{contactPerson}, #{phone}, #{jobLink})"
	})
	Integer save(Jobs jobs);


	@Select("SELECT * FROM Jobs LIMIT 10 ")
@Results({
	@Result(property="iD",column="ID")
	,@Result(property="companyID",column="CompanyID")
	,@Result(property="jobTitle",column="JobTitle")
	,@Result(property="jobDescription",column="JobDescription")
	,@Result(property="jobRequirement",column="JobRequirement")
	,@Result(property="jobType",column="JobType")
	,@Result(property="jobCIty",column="JobCIty")
	,@Result(property="jobSuburb",column="JobSuburb")
	,@Result(property="jobAddress",column="JobAddress")
	,@Result(property="publishDate",column="PublishDate")
	,@Result(property="contactPerson",column="ContactPerson")
	,@Result(property="phone",column="Phone")
	,@Result(property="jobLink",column="JobLink")
})
	List<Jobs> list();


	@Select("SELECT * FROM Jobs LIMIT #{start}, #{step}")
@Results({
	@Result(property="iD",column="ID")
	,@Result(property="companyID",column="CompanyID")
	,@Result(property="jobTitle",column="JobTitle")
	,@Result(property="jobDescription",column="JobDescription")
	,@Result(property="jobRequirement",column="JobRequirement")
	,@Result(property="jobType",column="JobType")
	,@Result(property="jobCIty",column="JobCIty")
	,@Result(property="jobSuburb",column="JobSuburb")
	,@Result(property="jobAddress",column="JobAddress")
	,@Result(property="publishDate",column="PublishDate")
	,@Result(property="contactPerson",column="ContactPerson")
	,@Result(property="phone",column="Phone")
	,@Result(property="jobLink",column="JobLink")
})
	List<Jobs> page(@Param("start") int start, @Param("step") int step );
	
}