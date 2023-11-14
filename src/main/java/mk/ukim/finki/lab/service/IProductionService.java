package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Production;

import java.util.List;

public interface IProductionService {
    List<Production> findAll();
}
