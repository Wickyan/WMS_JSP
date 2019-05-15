package com.briup.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import com.briup.bean.Customer;
import com.briup.common.MybatisSessionFactory;
import com.briup.dao.CustomerDao;
import com.briup.bean.CustomerMapper;


public class CustomerDaoImp implements CustomerDao{

	@Override
	public void saveCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();	
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
		//System.out.println("客户保存开始");
		customerMapper.insertCustomer(customer);
		//System.out.println("客户保存");
		session.commit();
		//session.close();
		//System.out.println("客户保存结束");
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();	
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
		customerMapper.updateCustomer(customer);
		session.commit();
		//session.close();

	}

	@Override
	public List<Customer> findCustomerByName(String name) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();	
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
		List<Customer> customer = customerMapper.selectCustomerByName(name);
		//session.close();

		return customer;
	}

//	@Override
//	public List<Customer> findCustomerById(int id) throws Exception {
//		// TODO Auto-generated method stub
//		SqlSession session = MybatisSessionFactory.getSession();
//		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
//		List<Customer> customer =  customerMapper.selectCustomerById(id);
//		     return customer;
//	}

	@Override
	public void deleteCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();	
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
	    customerMapper.deleteCustomer(customer);
		//session.close();

	}

	@Override
	public List<Customer> findAllCustomer() throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();	
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
	    //customerMapper.selectAllCustomer();
		//session.close();

		return customerMapper.selectAllCustomer();
	}

}
