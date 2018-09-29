package org.brewingjava.dao.categories;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.brewingjava.model.Categories;

public class CategoriesDAOImpl implements CategoriesDAO {

	private SqlSessionFactory sqlSessionFactory = null;

	public CategoriesDAOImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/**
	 * Returns the data of table 'Book' from the db
	 * 
	 * @return the data of table 'Book' from the db
	 */
	@SuppressWarnings("unchecked")
	public List<Categories> selectAll() {
		List<Categories> cat = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			cat = session.selectList("Categories.selectAll");
		} catch (Exception e) {
			System.out.println("Error fetching data");
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("Complete table Data- " + cat);
		return cat;
	}
}
