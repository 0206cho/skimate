package org.all4.skimate.cash.service;

import org.all4.skimate.cash.dto.CashDTO;
import org.all4.skimate.cash.entity.Cash;
import org.all4.skimate.cash.repository.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CashService {
	
	private final CashRepository cashRepository;
	
	public Cash saveCash(CashDTO dto ) {
		Cash cash = new Cash();
		cash.setCashPrice(dto.getPrice());
		cash.setCashCategory("스키장");
		return cashRepository.save(cash);
	}
	
}
