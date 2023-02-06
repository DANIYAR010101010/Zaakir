package com.io.muhsin.zaakir.ui.menu.reference

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.io.muhsin.zaakir.R
import com.io.muhsin.zaakir.databinding.FragmentReferenceBinding
import com.io.muhsin.zaakir.models.Learning


class ReferenceFragment : Fragment() {

    private lateinit var binding: FragmentReferenceBinding
    private lateinit var list: ArrayList<Learning>
    private lateinit var adapter: ReferenceAdapter
    private var db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentReferenceBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addReference()
    }
    private fun addReference() {
        list = arrayListOf()
        adapter = ReferenceAdapter(list)
        eventChangedListenerN()
        binding.recyclerReferences.adapter = adapter
        adapter.onClickItem={
            findNavController().navigate(R.id.resultFragment, bundleOf("learning" to it ))
        }

    }
    private fun eventChangedListenerN() {
        db = FirebaseFirestore.getInstance()
        db.collection("Reference").addSnapshotListener(
            object : EventListener<QuerySnapshot> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?,
                ) {

                    if(error!=null){
                        Log.e("FireStore error",error.message.toString())
                        return
                    }
                    for (dc: DocumentChange in value?.documentChanges!!){
                        if(dc.type == DocumentChange.Type.ADDED){
                            list.add(dc.document.toObject(Learning::class.java))
                        }
                    }
                    adapter.notifyDataSetChanged()
                }

            }
        )
    }

}