package com.briup.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.briup.bean.Admin;
import com.briup.bean.AdminMapper;
import com.briup.common.MybatisSessionFactory;
import com.briup.dao.AdminDao;

public class AdminDaoImp implements AdminDao {
	
	public AdminDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveAdmin(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();
		AdminMapper adminMapper = session.getMapper(AdminMapper.class);
		adminMapper.insertAdmin(admin);
		//session.close();
		session.commit();

		/*session.commit();
		session.close();*/
	}

	@Override
	public void updateAdmin(Admin admin) throws Exception{
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();
		AdminMapper adminMapper = session.getMapper(AdminMapper.class);
		adminMapper.updateAdmin(admin);
		session.commit();

		//session.close();
	}

	@Override
	public List<Admin> findAdminByName(String name) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();
		AdminMapper adminMapper = session.getMapper(AdminMapper.class);
		List<Admin> admin= adminMapper.selectAdminByName(name);
		/*session.commit();
		session.close();*/
		//session.close();
		return admin;
	}

//	@Override
//	public List<Admin> findAdminById(int id) throws Exception {
//		// TODO Auto-generated method stub
//		
//		AdminMapper adminMapper = session.getMapper(AdminMapper.class);
//		List<Admin> admin= adminMapper.selectAdminById(id);
//		session.commit();
//		session.close();
//		return admin;
//		
//	}

}
