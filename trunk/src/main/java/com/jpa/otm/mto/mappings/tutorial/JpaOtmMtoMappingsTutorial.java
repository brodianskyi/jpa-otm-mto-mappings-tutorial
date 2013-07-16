package com.jpa.otm.mto.mappings.tutorial;

import com.jpa.otm.mto.mappings.tutorial.domain.Album;
import com.jpa.otm.mto.mappings.tutorial.domain.Artist;
import com.jpa.otm.mto.mappings.tutorial.service.AlbumService;
import com.jpa.otm.mto.mappings.tutorial.service.ArtistService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaOtmMtoMappingsTutorial {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOtmMtoMappingsTutorial");
        EntityManager em = emf.createEntityManager();
        AlbumService albumService = new AlbumService(em);
        ArtistService artistService = new ArtistService(em);

        System.out.println("--- Finding albums ---");
        List<Album> albums = albumService.findAllAlbums();
        for (Album album : albums) {
            System.out.println(String.format("Found album: %s", album));
            System.out.println(String.format("Album artist: %s", album.getArtist()));
            System.out.println();
        }

        System.out.println("--- Finding artist ---");
        Artist artist = artistService.findArtist(1);
        System.out.println(String.format("Found artist: %s", artist));
        for (Album album : artist.getAlbums()) {
            System.out.println(String.format("Artist album: %s", album));
        }
    }
}
