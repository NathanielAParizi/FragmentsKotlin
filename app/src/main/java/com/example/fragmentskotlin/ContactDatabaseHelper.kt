package com.example.fragmentskotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.jetbrains.annotations.Contract

class PersonDatabaseHelper(context : Context)
    : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
        sqLiteDatabase?.execSQL(CREATE_PERSON_TABLE)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, previousVersion: Int, newVersion: Int) {
        onCreate(sqLiteDatabase)
    }

    fun insertPersonIntoDatabase(contact: Contact){
        val database = writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COL_NAME, contact.name)
        contentValues.put(COL_PHONENUMBER, contact.phoneNumber)


        database.insert(TABLE_NAME, null, contentValues)
        database.close()

    }

    fun getOnePersonFromDatabase(phoneNumber : String) : Contact? {
        val database = readableDatabase
        var contact : Contact? = null
        val cursor = database
            .rawQuery("SELECT * FROM $TABLE_NAME COL_PHONENUMBER = '$phoneNumber'",
                null)

        if(cursor.moveToFirst()) {
            val name = cursor.getString(cursor.getColumnIndex(COL_NAME))
            val phoneNumber = cursor.getString(cursor.getColumnIndex(COL_PHONENUMBER))
            contact = Contact(name, phoneNumber)
        }
        cursor.close()
        database.close()
        return contact
    }

    fun getAllPeopleFromDatabase() : ArrayList<Contact> {
        val database = readableDatabase
        var contactList : ArrayList<Contact> = ArrayList<Contact>()
        val cursor = database
            .rawQuery("SELECT * FROM $TABLE_NAME",
                null)

        if(cursor.moveToFirst()) {
            do {
                val name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                val phoneNumber = cursor.getString(cursor.getColumnIndex(COL_PHONENUMBER))
                val person = Contact(name, phoneNumber)
                contactList.add(person)
            } while(cursor.moveToNext())
        }

        cursor.close()
        database.close()
        return contactList
    }

    fun updatePersonInDatabase(contact : Contact) {
        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NAME, contact.name)
        contentValues.put(COL_PHONENUMBER, contact.phoneNumber)

        database.update(TABLE_NAME, contentValues, "$COL_PHONENUMBER = ?", arrayOf(contact.phoneNumber))
        database.close()
    }

    fun removePersonFromDatabase(phoneNumber : String) {
        val database = writableDatabase
        database.delete(TABLE_NAME, "$COL_PHONENUMBER = ?", arrayOf(phoneNumber))
        database.close()
    }
}