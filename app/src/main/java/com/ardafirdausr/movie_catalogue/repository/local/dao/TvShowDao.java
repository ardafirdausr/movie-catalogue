package com.ardafirdausr.movie_catalogue.repository.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ardafirdausr.movie_catalogue.repository.local.entity.TvShow;

import java.util.List;

@Dao
public interface TvShowDao {

    @Query("SELECT * FROM tv_shows")
    LiveData<List<TvShow>> getTvShows();

    @Query("SELECT * FROM tv_shows WHERE isFavourite = 1")
    LiveData<List<TvShow>> getFavouriteTvShows();

    @Query("SELECT * FROM tv_shows WHERE id=:id")
    LiveData<TvShow> getTvShow(long id);

    @Query("SELECT COUNT(*) FROM tv_shows")
    int countTvShows();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTvShows(List<TvShow> tvShows);

    @Query("UPDATE tv_shows SET isFavourite = 1 WHERE id = :tvShowId")
    void addTvShowToFavourite(long tvShowId);

    @Query("UPDATE tv_shows SET isFavourite = 0 WHERE id = :tvShowId")
    void removeTvShowFromFavourite(long tvShowId);

}
