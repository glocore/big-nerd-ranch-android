package co.metamodal.criminalintent

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Room
import co.metamodal.criminalintent.database.CrimeDatabase
import java.lang.IllegalStateException
import java.util.*

private const val TAG = "CrimeRepository"

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(context: Context) {

    private val database: CrimeDatabase = Room.databaseBuilder(
        context.applicationContext,
        CrimeDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.crimeDao()

    fun getCrimes(): LiveData<List<Crime>> = crimeDao.getCrimes()

    fun getCrime(id: UUID): LiveData<Crime?> = crimeDao.getCrime(id)

    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialise(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }

            Log.d(TAG, "Initialised")
        }

        fun get(): CrimeRepository {
            return INSTANCE ?: throw IllegalStateException("CrimeRepository must be initialised")
        }
    }
}