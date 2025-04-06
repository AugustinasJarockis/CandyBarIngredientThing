package candyBar.persistence;

import candyBar.entities.CandyBar;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CandyBarsDAO {
    @Inject
    private javax.persistence.EntityManager em;
    public void merge(CandyBar candyBar) {
        this.em.merge(candyBar);
    }
    public void persist(CandyBar candyBar){
        this.em.persist(candyBar);
    }
    public CandyBar findOne(Integer id){
        return em.find(CandyBar.class, id);
    }
    public List<CandyBar> loadAll() {
        return em.createQuery("SELECT c FROM CandyBar AS c", CandyBar.class).getResultList();
    }
}
