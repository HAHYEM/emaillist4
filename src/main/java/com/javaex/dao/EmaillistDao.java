package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.EmaillistVo;

@Repository // 자동으로 연결해줘라고 controller에서 선언해주고 연결을 할 때 repository에서 찾아달라는 것.
public class EmaillistDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<EmaillistVo> getList(){
		
		List<EmaillistVo> list = sqlSession.selectList("emaillist.getList");
		return list;
	}
	
	public void insert(EmaillistVo emaillistVo) {
		
		int count = sqlSession.insert("emaillist.insert", emaillistVo);
		System.out.println(count+"건 성공하였음!!!!!");
		
	}
	
	public void getListByMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("last_name", "정");
		map.put("email", "nnnn");
		List<EmaillistVo> list = sqlSession.selectList("emaillist.getListByMap", map);
	}
	
}
