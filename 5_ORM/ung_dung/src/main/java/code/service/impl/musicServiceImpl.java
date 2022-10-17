package code.service.impl;

import code.model.Music;
import code.reponsitory.iMusicReponsitory;
import code.service.iMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class musicServiceImpl implements iMusicService<Music> {
    @Autowired
    iMusicReponsitory<Music> musicReponsitory;

    @Override
    public List<Music> findAll() {
        return musicReponsitory.findAll();
    }

    @Override
    public void addMusic(Music music) {
        musicReponsitory.addMusic(music);
    }

    @Override
    public void edit(Music music) {
        musicReponsitory.edit(music);
    }

    @Override
    public void delete(int id) {
        musicReponsitory.delete(id);
    }

    @Override
    public Music findById(int id) {
        return musicReponsitory.findById(id);
    }

    @Override
    public List<Music> findByName(String name) {
        return musicReponsitory.findByName(name);
    }
}
