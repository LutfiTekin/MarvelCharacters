package com.marvel.characters.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.marvel.characters.R


class CharacterDetail: BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_character_detail, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle): CharacterDetail {
            val fragment = CharacterDetail()
            fragment.arguments = bundle
            return fragment
        }
    }

}