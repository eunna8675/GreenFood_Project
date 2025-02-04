package net.developia.greenfood.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.developia.greenfood.dao.ProductDAO;
import net.developia.greenfood.dto.CartDTO;
import net.developia.greenfood.dto.ProductDTO;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;

	@Override
	public void selectProduct(HashMap<String, Object> map) throws Exception {
		try {
			productDAO.selectProduct(map);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}

	}

	@Override
	public void selectImage(HashMap<String, Object> map) throws Exception {
		try {
			productDAO.selectImage(map);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public void selectProductDetail(HashMap<String, Object> map) throws Exception {
		try {
			productDAO.selectProductDetail(map);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public void selectProductByCategory(HashMap<String, Object> map) throws Exception {
		try {
			productDAO.selectProductByCategory(map);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public void addCart(HashMap<String, Object> map) throws Exception {
		try {
			productDAO.addCart(map);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public void selectcart(HashMap<String, Object> map) throws Exception {
		try {
			productDAO.selectcart(map);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public void quantityUpdate(HashMap<String, Object> map) throws Exception {
		try {
			productDAO.quantityUpdate(map);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public void removeProduct(HashMap<String, Object> map) throws Exception {
		try {
			productDAO.removeProduct(map);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public void productAddcart(HashMap<String, Object> map) throws Exception {
		try {
			productDAO.selectProductByNo(map);
			List<ProductDTO> data = (List) map.get("ProductList");
			ProductDTO dto = data.get(0);
			map.put("NAME", dto.getName());
			map.put("PRICE", dto.getPrice());
			map.put("CNT", 1);
			productDAO.addCart(map);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public void insertOrderlist(HashMap<String, Object> map) throws Exception {
		try {
			productDAO.insertOrderlist(map);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}
}
