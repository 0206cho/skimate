package org.all4.skimate.cash.service;

import org.all4.skimate.cash.repository.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CashService {
	
	@Autowired
	private CashRepository cashRepository;
	
	public void saveCash() {
	
	}
	
}
