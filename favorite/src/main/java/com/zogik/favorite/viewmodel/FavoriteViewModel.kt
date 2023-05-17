package com.zogik.favorite.viewmodel

//
// @HiltViewModel
// class FavoriteViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {
//    private val _favorite: MutableLiveData<List<Track>> = MutableLiveData()
//    val favorite: LiveData<List<Track>> = _favorite
//
//    fun getFavorite() {
//        viewModelScope.launch {
//            useCase.getFavorite().collectLatest {
//                _favorite.value = it
//            }
//        }
//    }
// }
