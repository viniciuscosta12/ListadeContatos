package com.example.listatelefonica.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listatelefonica.adapter.ContatoListAdapter
import com.example.listatelefonica.adapter.listener.ContatoOnClickListener
import com.example.listatelefonica.databinding.ActivityMainBinding
import com.example.listatelefonica.model.Contato
import com.example.listatelefonica.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var adapter: ContatoListAdapter
    private var listaContato: List<Contato> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.recyclerViewContatos.layoutManager = LinearLayoutManager(this)
        viewModel.getListaContato()
        observe()

        binding.buttonNovoContato.setOnClickListener {
            launcher.launch(Intent(applicationContext, NovoContatoActivity::class.java))
        }

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data != null && it.resultCode == 1) {
                viewModel.getListaContato()
            }
        }
    }

    private fun placeAdapter() {
        adapter = ContatoListAdapter(listaContato, ContatoOnClickListener { contato ->
            val i = Intent(this, DetalhesContatoActivity::class.java)
            i.putExtra("id", contato.id)
            launcher.launch(i)
        })
        binding.recyclerViewContatos.adapter = adapter
    }

    private fun observe() {
        viewModel.listaContatos().observe(this, Observer {
            listaContato = it
            placeAdapter()
        })
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = listaContato.filter { contato ->
                    contato.nome.contains(newText ?: "", ignoreCase = true) ||
                            contato.telefone.contains(newText ?: "", ignoreCase = true) ||
                            contato.email.contains(newText ?: "", ignoreCase = true)
                }
                adapter.updateList(filteredList)
                return true
            }
        })
    }


}

