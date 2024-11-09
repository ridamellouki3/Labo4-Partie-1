package com.rida.ggtoolbarmellouki

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import com.rida.ggtoolbarmellouki.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding ;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbar)
        registerForContextMenu(binding.tvContextualMenu)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_toolbar_settings -> {
                startActivity(Intent(Settings.ACTION_SETTINGS))
                true
            }
            R.id.menu_toolbar_call -> {
                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:5146262666")
                startActivity(dialIntent)
                true
            }
            R.id.menu_toolbar_email -> {
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("mailto:infogg@cgodin.qc.ca")
                intent.putExtra(Intent.EXTRA_SUBJECT, "Coucou...")
                intent.putExtra(Intent.EXTRA_TEXT, "Bonjour tout le monde!")

                        startActivity(Intent.createChooser(intent, "Select app..."))
                    true
            }
            R.id.menu_toolbar_profile -> {
                //Toast.makeText(this,"Merci" ,Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_toolbar_help -> {
                Toast.makeText(this@MainActivity, getString(R.string.menu_selectionne,item.title),Toast.LENGTH_SHORT).show()
                true
            }
            R.id.option1_1 ->   {
                Toast.makeText(this@MainActivity,getString(R.string.menu_selectionne,item.title),Toast.LENGTH_SHORT).show()
                true
            }
            R.id.option1_2 ->   {
                Toast.makeText(this@MainActivity,getString(R.string.menu_selectionne,item.title),Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        when(v?.id){
            R.id.tvContextualMenu ->
                menuInflater.inflate(R.menu.menu_contextuel, menu)
            else -> super.onCreateContextMenu(menu, v, menuInfo)
        }
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this,
            getString(R.string.menu_selectionne, item.title),
            Toast.LENGTH_LONG
        ).show();
        return when(item.itemId){
            R.id.menu_contextuel_option1,
            R.id.menu_contextuel_option2,
            R.id.menu_contextuel_option3,
            R.id.menu_contextuel_option4,
            R.id.menu_contextuel_option5 -> {
                item.isChecked = !item.isChecked
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}