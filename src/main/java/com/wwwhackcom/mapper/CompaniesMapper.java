package com.wwwhackcom.mapper;
import java.util.*;
import com.wwwhackcom.model.Companies;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;

public interface CompaniesMapper{

	@Select("SELECT COUNT(*) FROM Companies ")
	Integer count();


	@Select("SELECT * FROM Companies WHERE ID = #{ID} LIMIT 1 ")
	@Results({
			@Result(property="iD",column="ID")
			,@Result(property="name",column="Name")
			,@Result(property="description",column="Description")
			,@Result(property="country",column="Country")
			,@Result(property="city",column="City")
			,@Result(property="suburb",column="Suburb")
			,@Result(property="address",column="Address")
			,@Result(property="zipcode",column="Zipcode")
			,@Result(property="phone",column="Phone")
			,@Result(property="email",column="Email")
	})
	Companies getByID(@Param("ID") Integer ID);


	@Delete("DELETE FROM Companies WHERE ID = #{ID} ")
	Integer deleteByID(@Param("ID") Integer ID);

	@Update({
		"UPDATE Companies SET Name=#{name}, Description=#{description}, Country=#{country}, City=#{city}, Suburb=#{suburb}, Address=#{address}, Zipcode=#{zipcode}, Phone=#{phone}, Email=#{email} where ID = #{ID}"
	})
	Integer update(Companies companies);

	@Insert({
		"INSERT IGNORE INTO Companies (`Name`, `Description`, `Country`, `City`, `Suburb`, `Address`, `Zipcode`, `Phone`, `Email`) VALUE (#{name}, #{description}, #{country}, #{city}, #{suburb}, #{address}, #{zipcode}, #{phone}, #{email})"
	})
	Integer save(Companies companies);


	@Select("SELECT * FROM Companies LIMIT 10 ")
@Results({
	@Result(property="iD",column="ID")
	,@Result(property="name",column="Name")
	,@Result(property="description",column="Description")
	,@Result(property="country",column="Country")
	,@Result(property="city",column="City")
	,@Result(property="suburb",column="Suburb")
	,@Result(property="address",column="Address")
	,@Result(property="zipcode",column="Zipcode")
	,@Result(property="phone",column="Phone")
	,@Result(property="email",column="Email")
})
	List<Companies> list();


	@Select("SELECT * FROM Companies LIMIT #{start}, #{step}")
@Results({
	@Result(property="iD",column="ID")
	,@Result(property="name",column="Name")
	,@Result(property="description",column="Description")
	,@Result(property="country",column="Country")
	,@Result(property="city",column="City")
	,@Result(property="suburb",column="Suburb")
	,@Result(property="address",column="Address")
	,@Result(property="zipcode",column="Zipcode")
	,@Result(property="phone",column="Phone")
	,@Result(property="email",column="Email")
})
	List<Companies> page(@Param("start") int start, @Param("step") int step );
	
}