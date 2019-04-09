package vu.lt.persistence;

import vu.lt.entities.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequestScoped
public class PlayersDAO {

    @Inject
    private EntityManager em;

    public void persist(Player player){
        this.em.persist(player);
    }
}
