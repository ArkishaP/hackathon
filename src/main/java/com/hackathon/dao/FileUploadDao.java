package com.hackathon.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.hackathon.model.ExcelFile;


@Repository("fileUploadDao")
public class FileUploadDao extends BaseDao{
	@Autowired
	DriverManagerDataSource dataSource;
	public boolean saveFileDataInDB(List<ExcelFile> list){
		String sql = "insert into Question (id, Question, Option1, Option2, Option3, Option4, Correct_answer, Subject_id) "
				+ " VALUES (:Question_no, :Question, :Option1, :Option2, :Option3, :Option4, :Correct_answer, :Subject_id)";
		try {
			List<Map<String, String>> batchUpdateParams = new ArrayList<Map<String,String>>();
			
				for(ExcelFile vo : list){
					Map<String, String> paramMap = new HashMap<String,String>();
					paramMap.put("Question_no", vo.getQuestion_no());
					paramMap.put("Question", vo.getQuestion());
					paramMap.put("Option1", vo.getOption1());
					paramMap.put("Option2", vo.getOption2());
					paramMap.put("Option3", vo.getOption3());
					paramMap.put("Option4", vo.getOption4());
					paramMap.put("Correct_answer", vo.getCorrect_answer());
					paramMap.put("Subject_id", vo.getSubject_id());
					batchUpdateParams.add(paramMap);
				}
				NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(dataSource); 
				// datasource from JDBC.
				jdbc.batchUpdate(sql, batchUpdateParams.toArray(new Map[batchUpdateParams.size()]));
//				getNamedParamJdbcTemplate().batchUpdate(sql, batchUpdateParams.toArray(new Map[batchUpdateParams.size()] ));
			
		} catch (Exception e) {
			e.printStackTrace(); 
			return false;
		}
		
		return true;
		
	}

}