package com.sample.mad.fifth;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "topic")
public class Topic {
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "desc")
    private String description;

    public Topic(@NonNull String title, String description) {
        this.title = title;
        this.description = description;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
