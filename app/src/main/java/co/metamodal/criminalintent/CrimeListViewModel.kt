package co.metamodal.criminalintent

import androidx.lifecycle.ViewModel

class CrimeListViewModel: ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()
}

//class CrimeListViewModel: ViewModel() {
////    val crimes = mutableListOf<Crime>()
//    val crimeListLiveData = mutableListOf<Crime>()
//
//    init {
//        for (i in 0 until 100) {
//            val crime = Crime()
//
//            crime.title = "Crime #$i"
//            crime.isSolved = i % 2 == 0
//            crime.requiresPolice = i % 2 == 0
//
//            crimeListLiveData += crime
//        }
//
//    }
//}