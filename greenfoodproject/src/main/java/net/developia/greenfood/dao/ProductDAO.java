package net.developia.greenfood.dao;

import java.sql.SQLException;
import java.util.HashMap;

public interface ProductDAO {

	void selectProduct(HashMap<String, Object> map) throws SQLException;

	void selectImage(HashMap<String, Object> map) throws SQLException;

	void selectProductDetail(HashMap<String, Object> map) throws SQLException;

	void selectProductByCategory(HashMap<String, Object> map) throws SQLException;

	void addCart(HashMap<String, Object> map) throws SQLException;

	void selectcart(HashMap<String, Object> map) throws SQLException;

	void quantityUpdate(HashMap<String, Object> map) throws SQLException;

	void removeProduct(HashMap<String, Object> map) throws SQLException;

	void productAddcart(HashMap<String, Object> map) throws SQLException;

	void selectProductByNo(HashMap<String, Object> map) throws SQLException;

	void insertOrderlist(HashMap<String, Object> map) throws SQLException;

}
