package com.sheena.SpringTest.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheena.SpringTest.lesson02.dao.StoreDAO;
import com.sheena.SpringTest.lesson02.model.Store;

@Service
public class StoreBO {
	
	@Autowired
	private StoreDAO storeDAO;

	public List<Store> getStoreList() {
		
		List<Store> storeList = storeDAO.selectStoreList();
		return storeList;
		
	}
	
}
