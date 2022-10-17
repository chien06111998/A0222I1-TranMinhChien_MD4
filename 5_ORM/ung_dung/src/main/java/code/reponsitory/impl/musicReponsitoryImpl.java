package code.reponsitory.impl;

import code.model.Music;
import code.reponsitory.BaseReponsitory;
import code.reponsitory.iMusicReponsitory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class musicReponsitoryImpl implements iMusicReponsitory<Music> {
    String findAll = "select m from music as m";
    String findById = "select m from music as m where m.id = :id";
    String findByName = "select m from music as m where m.name_song like :name";

    @Override
    public List<Music> findAll() {
        List<Music> musicList = BaseReponsitory.entityManager.createQuery(findAll, Music.class).getResultList();
        return musicList;
    }

    @Override
    public void addMusic(Music music) {
        EntityTransaction entityTransaction =BaseReponsitory.entityManager.getTransaction();
        entityTransaction.begin();
        BaseReponsitory.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public void edit(Music music) {
        EntityTransaction entityTransaction = BaseReponsitory.entityManager.getTransaction();
        entityTransaction.begin();
        BaseReponsitory.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseReponsitory.entityManager.getTransaction();
        entityTransaction.begin();
        BaseReponsitory.entityManager.remove(BaseReponsitory.entityManager.find(Music.class, id));
        entityTransaction.commit();
    }

    @Override
    public Music findById(int id) {
        TypedQuery<Music> musicTypedQuery = BaseReponsitory.entityManager.createQuery(findById, Music.class);
        musicTypedQuery.setParameter("id", id);
        return (Music) musicTypedQuery.getResultList();
    }

    @Override
    public List<Music> findByName(String name) {
        TypedQuery<Music> musicTypedQuery = BaseReponsitory.entityManager.createQuery(findByName, Music.class);
        musicTypedQuery.setParameter("name", '%' + name + '%');
        return musicTypedQuery.getResultList();
    }
}
