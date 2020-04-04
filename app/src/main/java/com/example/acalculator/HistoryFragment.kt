package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.graphics.Path
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Optional
import kotlinx.android.synthetic.main.fragment_calculator.*
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.history_activity.*

class HistoryFragment : Fragment() {

    private val EXTRA = "texto"
    private var operations = ArrayList<Operation>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        arguments?.let {
            operations = it.getParcelableArrayList(EXTRA)
        }
        val view = inflater?.inflate(R.layout.fragment_history, container, false)
        lista_historico?.layoutManager = LinearLayoutManager(activity as Context)
        lista_historico?.adapter = HistoryAdapter(activity as Context, R.layout.item_expression, operations)
        return view
    }
    @Optional
    @OnClick(R.id.button_back)
    fun OnClickBack(view: View)
    {
        /*val intent = Intent(this, MainActivity::class.java)
        intent.putParcelableArrayListExtra(EXTRA, operations)
        startActivity(intent)
        finish()*/
    }
}


