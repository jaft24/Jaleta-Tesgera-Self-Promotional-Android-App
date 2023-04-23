package com.example.jtesgera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.jtesgera.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

/*
Author: Jaleta F Tesgera
Project Title: Self-Promotional App Development Milestone 3

Sources
-------
. Our Book: Head First Android Development, Third Edition
. Full Kotlin Course Tutorial with Jet Pack Compose: https://www.youtube.com/watch?v=BCSlZIUj18Y&t=135s
. Drawer Navigation Video Series: 1. https://www.youtube.com/watch?v=zQh-QGGKPw0
                                  2. https://www.youtube.com/watch?v=AxjKfZr3Crk
. Android Studio Dependencies: https://developer.android.com/jetpack/androidx/releases/navigation
. I have also consulted a lot about this project, especially the navigation, with my class Peers Segni Tulu, and Brook Mulu

Functionality Note
------------------
. The navigation from the home page to the different pages and the button from the project list towards their details work as required
and as implemented by the navigation graph.
. Additionally, the navigation drawer fully works and takes the user to the page they requested.
. However, my code has one bug: the navigation with buttons works; however, once I navigate with the drawer and try to navigate
with the buttons again the app exits from my phone with an error. I have the error posted at the end. Whenever I start navigation with
a drawer the buttons stop working. If I don't use the drawer the buttons will work just fine. The drawers work whether I us the buttons
to navigate or not. The error only happens once I navigate with my drawer and attempt to navigate with the buttons. I have tried a lot of
solutions, sources, videos, and stack overflow and I haven't been able to find a solution. I will consult with you over the office hours
you have next week. Thank you and I hope you enjoy the content and UI.

Error Message: IllegalStateException: View com.google.android.material.button.MaterialButton does not have a NavController set

*/

class MainActivity : AppCompatActivity() {

    // Declare a binding lateinit variable to hold this Fragment
    private lateinit var binding: ActivityMainBinding

    // Declare a lateinit variable toogle and drawer Layout for the Naviagtion Drawer
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate this fragment using the binding var we declared above
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Find the Drawer layout from the Main Activity Layout File
        drawerLayout = findViewById(R.id.drawerLayout)

        // Declare a val navView from the navigation menu file
        val navView : NavigationView = findViewById(R.id.nav_view)

        /* This code makes the ActionBarDrawerToggle, it starts from syncing the toggle and
        drawer layout listens to any toggle (action), then the ActionBarDrawerToggle is implemented
        where it connects this activity's drawer to the action bar */
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //using the safe navigation null checker operator this line still makes the home navigation enabled even if we are in the Home Fragment
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Find items along with their Id's in the nav_view and replace this fragment with the fragments selected
        navView.setNavigationItemSelectedListener {
            it.isChecked = true // same as "if the item in the navigation menu is clicked"
            when (it.itemId) {
                // The id for the navigation Menu clicked -> replace this fragment with the required fragment and set the tool bars title same as the new fragment
                R.id.nav_home -> replaceFragment(HomeFragment(), it.title.toString())
                R.id.nav_biography -> replaceFragment(BiographyFragment(), it.title.toString())
                R.id.nav_contactMe -> replaceFragment(ContactFragment(), it.title.toString())
                R.id.nav_projectList -> replaceFragment(ProjectListFragment(), it.title.toString())
                R.id.nav_projectDetail1 -> replaceFragment(NewRozKebabFragment(), it.title.toString())
                R.id.nav_projectDetail2 -> replaceFragment(BreakingPovertyCycleFragment(), it.title.toString())
                R.id.nav_options -> replaceFragment(OptionsFragment(), it.title.toString())
            }
            true
        }


    }

    /* As the name states the replace fragment function takes in two parameters i.e. the new fragment and a String
       the function traces the Id for the fragmentContainerView we have in the main activity layout and replaces it with
       the new fragment required, as it does that it sets the title for the Tool Bar same as the Fragment we are in. */
    private fun replaceFragment(fragment: Fragment, title : String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    /* This function allows the toggle object to handle menu item selections if it is capable of doing so,
    while falling back to the superclass's implementation if necessary.  */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}