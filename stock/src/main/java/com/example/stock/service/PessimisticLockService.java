package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessimisticLockService {

    private final StockRepository stockRepository;

    public PessimisticLockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void descrese(Long id, Long quantity) {
        Stock stock = stockRepository.findByIdWithPessimisticLock(id);
        // 재고 감소
        stock.decrease(quantity);
        // 갱신된 값 저장

        stockRepository.saveAndFlush(stock);
    }
}
