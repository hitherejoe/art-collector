package com.ataulm.artcollector.painting.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ataulm.artcollector.painting.domain.GetPaintingUseCase
import javax.inject.Inject

internal class PaintingViewModelFactory @Inject constructor(
        private val paintingUseCase: GetPaintingUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
            PaintingViewModel(paintingUseCase) as T
}
