package com.briup.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Goods;
import com.briup.bean.GoodsMapper;
import com.briup.common.MybatisSessionFactory;
import com.briup.dao.GoodsDao;

public class GoodsDaoImp implements GoodsDao{
//	SqlSession session = MybatisSessionFactory.getSession();
	@Override
	public void saveGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();	
		GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
		goodsMapper.insertGoods(goods);
		session.commit();
		//session.close();

	}

	@Override
	public void updateGoods(Goods goods) throws Exception{
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();	
		GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
		goodsMapper.updateGoods(goods);
		session.commit();

	}
    
	@Override
	public List<Goods> findGoodsByName(String name) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();	
		GoodsMapper goodsMapper=session.getMapper(GoodsMapper.class);
		List<Goods> gList = goodsMapper.selectGoodsByName(name);
		return gList;
	}

	

	@Override
	public List<Goods> findGoods() throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		try {
			GoodsMapper goodsMapper=session.getMapper(GoodsMapper.class);
			List<Goods> AGoods = goodsMapper.selectAllGoods();
			for (Goods goods : AGoods) {
				System.out.println(goods.toString());
			}
			return AGoods;
		} finally {
//			session.commit();
//			session.clearCache();
//			session.close();
		}
		
//		for (Goods goods : AGoods) {
//			System.out.println(goods.toString());
//		}
//		 if (session !=null){
//	            session.close();
//         }

	}

	@Override
	public List<Goods> findGoodsById(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();	
		GoodsMapper goodsMapper=session.getMapper(GoodsMapper.class);
		List<Goods> gList = goodsMapper.selectGoodsById(id);
		//session.close();

		return gList;
		
	}

	@Override
	public void updateGoodsAll(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();	
		GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
		goodsMapper.updateGoodsAll(goods);
		System.out.println("updateGoodsAll" + goods.toString());
		session.commit();
	}

	@Override
	public void deleteGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSessionFactory.getSession();
		session.clearCache();session.clearCache();session.clearCache();	
		GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
		goodsMapper.deleteGoods(goods);
		session.commit();
	}

	

}
