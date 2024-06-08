package jpa.core.facade;


import jakarta.transaction.Transactional;
import jpa.core.repository.LockRepository;
import jpa.core.service.StockService;
import org.springframework.stereotype.Component;

@Component
public class NamedLockStockFacade {

   private final LockRepository lockRepository;

   private final StockService stockService;

    public NamedLockStockFacade(LockRepository lockRepository, StockService stockService) {
        this.lockRepository = lockRepository;
        this.stockService = stockService;
    }

    @Transactional
    public void decrease(Long id, Long quantity) {
       try {
           lockRepository.getLock(id.toString());
           stockService.decrease(id, quantity);
       } finally {
           lockRepository.releaseLock(id.toString());
       }
    }
}
