package code.reponsitory;

import java.util.List;

public interface iMusicReponsitory<E> {
    List<E> findAll();

    void addMusic(E e);

    void edit(E e);

    void delete(int id);

    E findById(int id);

    List<E> findByName(String name);
}
