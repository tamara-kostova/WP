package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Production;
import mk.ukim.finki.lab.repository.ProductionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionService implements IProductionService{
    private final ProductionRepository productionRepository;

    public ProductionService(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    @Override
    public List<Production> findAll() {

        return productionRepository.findAll();
    }
}
