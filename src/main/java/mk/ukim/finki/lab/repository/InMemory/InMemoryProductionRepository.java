package mk.ukim.finki.lab.repository.InMemory;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.Production;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryProductionRepository {
    public List<Production> findAll(){
        return DataHolder.productions;
    }
    public Production findById(long id){
        return DataHolder.productions.stream().filter(p->p.getId()==id).findFirst().orElse(null);
    }
}
