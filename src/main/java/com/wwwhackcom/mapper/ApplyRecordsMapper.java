package com.wwwhackcom.mapper;
import java.util.*;
import com.wwwhackcom.model.ApplyRecords;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;

public interface ApplyRecordsMapper{

	@Select("SELECT COUNT(*) FROM ApplyRecords ")
	Integer count();


	@Select("SELECT * FROM ApplyRecords WHERE ID = #{ID} LIMIT 1 ")
	@Results({
			@Result(property="iD",column="ID")
			,@Result(property="jobID",column="JobID")
			,@Result(property="applyDate",column="ApplyDate")
			,@Result(property="status",column="Status")
			,@Result(property="replyDate",column="ReplyDate")
			,@Result(property="replyContent",column="ReplyContent")
			,@Result(property="replyPersonName",column="ReplyPersonName")
			,@Result(property="replyContact",column="ReplyContact")
			,@Result(property="furtherStep",column="FurtherStep")
			,@Result(property="futherCalendar",column="FutherCalendar")
	})
	ApplyRecords getByID(@Param("ID") Integer ID);


	@Delete("DELETE FROM ApplyRecords WHERE ID = #{ID} ")
	Integer deleteByID(@Param("ID") Integer ID);

	@Update({
		"UPDATE ApplyRecords SET JobID=#{jobID}, ApplyDate=#{applyDate}, Status=#{status}, ReplyDate=#{replyDate}, ReplyContent=#{replyContent}, ReplyPersonName=#{replyPersonName}, ReplyContact=#{replyContact}, FurtherStep=#{furtherStep}, FutherCalendar=#{futherCalendar} where ID = #{ID}"
	})
	Integer update(ApplyRecords applyRecords);

	@Insert({
		"INSERT IGNORE INTO ApplyRecords (`JobID`, `ApplyDate`, `Status`, `ReplyDate`, `ReplyContent`, `ReplyPersonName`, `ReplyContact`, `FurtherStep`, `FutherCalendar`) VALUE (#{jobID}, #{applyDate}, #{status}, #{replyDate}, #{replyContent}, #{replyPersonName}, #{replyContact}, #{furtherStep}, #{futherCalendar})"
	})
	Integer save(ApplyRecords applyRecords);


	@Select("SELECT * FROM ApplyRecords LIMIT 10 ")
@Results({
	@Result(property="iD",column="ID")
	,@Result(property="jobID",column="JobID")
	,@Result(property="applyDate",column="ApplyDate")
	,@Result(property="status",column="Status")
	,@Result(property="replyDate",column="ReplyDate")
	,@Result(property="replyContent",column="ReplyContent")
	,@Result(property="replyPersonName",column="ReplyPersonName")
	,@Result(property="replyContact",column="ReplyContact")
	,@Result(property="furtherStep",column="FurtherStep")
	,@Result(property="futherCalendar",column="FutherCalendar")
})
	List<ApplyRecords> list();


	@Select("SELECT * FROM ApplyRecords LIMIT #{start}, #{step}")
@Results({
	@Result(property="iD",column="ID")
	,@Result(property="jobID",column="JobID")
	,@Result(property="applyDate",column="ApplyDate")
	,@Result(property="status",column="Status")
	,@Result(property="replyDate",column="ReplyDate")
	,@Result(property="replyContent",column="ReplyContent")
	,@Result(property="replyPersonName",column="ReplyPersonName")
	,@Result(property="replyContact",column="ReplyContact")
	,@Result(property="furtherStep",column="FurtherStep")
	,@Result(property="futherCalendar",column="FutherCalendar")
})
	List<ApplyRecords> page(@Param("start") int start, @Param("step") int step );
	
}