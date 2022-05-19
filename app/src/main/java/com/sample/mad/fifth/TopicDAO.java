package com.sample.mad.fifth;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface TopicDAO {
    @Insert
    Completable insert(Topic topic);

    @Update
    Completable update(Topic topic);

    @Query("SELECT * FROM topic WHERE title = :title")
    Topic select(String title);

    @Query("DELETE FROM topic WHERE title = :title")
    Completable delete(String title);

    @Query("DELETE FROM topic")
    Completable clear();
}
