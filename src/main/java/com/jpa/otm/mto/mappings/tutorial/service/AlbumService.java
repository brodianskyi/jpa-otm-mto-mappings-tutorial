package com.jpa.otm.mto.mappings.tutorial.service;

import com.jpa.otm.mto.mappings.tutorial.domain.Album;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumService {

    private EntityManager em;

    public AlbumService(EntityManager em) {
        this.em = em;
    }

    public Album createAlbum(int id, String name, int year) {
        Album album = new Album(id, name, year);
        em.persist(album);

        return album;
    }

    public void removeAlbum(int id) {
        Album album = em.find(Album.class, id);

        if (album != null) {
            em.remove(album);
        }
    }

    public Album changeAlbumName(int id, String name) {
        Album album = em.find(Album.class, id);

        if (album != null) {
            album.setName(name);
        }

        return album;
    }

    public Album findAlbum(int id) {
        return em.find(Album.class, id);
    }

    public List<Album> findAllAlbums() {
        TypedQuery<Album> query = em.createQuery("SELECT a FROM Album a", Album.class);
        return query.getResultList();
    }
}