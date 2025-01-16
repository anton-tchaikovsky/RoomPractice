package com.example.roompractice.com.example.roompractice.data.room

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE bouquets ADD COLUMN is_basket INTEGER DEFAULT 0 NOT NULL")
        db.execSQL("ALTER TABLE bouquets ADD COLUMN is_craft_paper INTEGER DEFAULT 0 NOT NULL")
        db.execSQL("ALTER TABLE flowers ADD COLUMN country TEXT DEFAULT 'indefinite' NOT NULL")
    }
}
