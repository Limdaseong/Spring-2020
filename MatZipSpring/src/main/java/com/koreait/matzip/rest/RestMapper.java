package com.koreait.matzip.rest;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.koreait.matzip.rest.model.RestDMI;
import com.koreait.matzip.rest.model.RestPARAM;

@Mapper
public interface RestMapper {
	List<RestDMI> selRestList(RestPARAM p);
	int insRest(RestPARAM p); 
	// 성공했는지 안했는지 알기 위해 int형
	RestDMI selRest(RestPARAM p);
}
