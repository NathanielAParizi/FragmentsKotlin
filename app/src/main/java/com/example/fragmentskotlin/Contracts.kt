package com.example.fragmentskotlin


const val DATABASE_NAME = "data_per_database"
const val TABLE_NAME = "person_table"
const val DATABASE_VERSION = 1
const val COL_NAME = "full_name"
const val COL_PHONENUMBER = "phone_number"


const val CREATE_PERSON_TABLE =
    "CREATE TABLE $TABLE_NAME (" +
            "$COL_NAME String," +
            "$COL_PHONENUMBER String PRIMARY_KEY)"