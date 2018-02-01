package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.EmaillistVo;

@Repository // �ڵ����� ���������� controller���� �������ְ� ������ �� �� repository���� ã�ƴ޶�� ��.
public class EmaillistDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<EmaillistVo> getList(){
		
		List<EmaillistVo> list = sqlSession.selectList("emaillist.getList");
		return list;
	}
	
	public void insert(EmaillistVo emaillistVo) {
		
		int count = sqlSession.insert("emaillist.insert", emaillistVo);
		System.out.println(count+"�� �����Ͽ���!!!!!");
		
	}
	
	public void getListByMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("last_name", "��");
		map.put("email", "nnnn");
		List<EmaillistVo> list = sqlSession.selectList("emaillist.getListByMap", map);
	}
	
}
