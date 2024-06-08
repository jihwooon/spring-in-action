package jpa.core.service;

import jakarta.transaction.Transactional;
import jpa.core.domain.Stock;
import jpa.core.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class PessimisticLockStockService {

    private final StockRepository stockRepository;

    public PessimisticLockStockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrease(final Long id, Long quantity) {
        Stock stock = stockRepository.findByIdWithPessimisticLock(id);

        stock.decrease(quantity);

        stockRepository.save(stock);
    }
}
