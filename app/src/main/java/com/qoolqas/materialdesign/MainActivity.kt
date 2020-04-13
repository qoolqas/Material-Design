package com.qoolqas.materialdesign

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.qoolqas.materialdesign.ui.ServicesActivity
import com.qoolqas.materialdesign.ui.WebActivity

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val navSend = navView.menu.findItem(R.id.nav_send)
        navSend.setOnMenuItemClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:089529272555"))
            intent.putExtra("sms_body", "Halo gaes david disini")
            startActivity(intent)
            true
        }
        val navWeb = navView.menu.findItem(R.id.nav_web)
        navWeb.setOnMenuItemClickListener {
            val intent = Intent(applicationContext, WebActivity::class.java)
            startActivity(intent)
            true
        }
        val navShare = navView.menu.findItem(R.id.nav_share)
        val intent = Intent(Intent.ACTION_SEND)
        navShare.setOnMenuItemClickListener {
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Halo gaes David disini")
            startActivity(Intent.createChooser(intent, "Share gaes"))
            true
        }
        val navService = navView.menu.findItem(R.id.nav_service)
        navService.setOnMenuItemClickListener {
            val intent1 = Intent(applicationContext, ServicesActivity::class.java)
            startActivity(intent1)
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_call){
            val intent = Intent(Intent.ACTION_DIAL,Uri.parse("tel:089529272555"))
            startActivity(intent)

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
