package space.pablorjd.usersharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import space.pablorjd.usersharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: LayoutManager
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(getUser())

        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }


    private fun getUser(): MutableList<User> {
        val user = mutableListOf<User>()

        val pablo = User(1,"Pablo","Jimenez", "https://upload.wikimedia.org/wikipedia/commons/f/ff/Chris_Hemsworth_Thor_2_cropped.png")
        val user1 = User(1,"Florencia","Jimenez", "https://elcomercio.pe/resizer/kzA7GjtSnLhUz6nZEM9pr2b2H_E=/1200x1200/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/2IRVLDWH2VBA5F2DAMVVR5DHJU.jpg")
        val user2 = User(1,"Maximiliano","Jimenez", "https://www.mundodeportivo.com/alfabeta/hero/2022/08/Definitivamente-Hulk-enojado-es-mucho-mas-poderoso-que-su-prima.jpg")
        val user3 = User(1,"Litzi","Caceres", "https://i0.wp.com/imgs.hipertextual.com/wp-content/uploads/2020/01/hipertextual-mira-espectacular-nuevo-trailer-viuda-negra-2020457263.jpg")

        user.add(pablo)
        user.add(user1)
        user.add(user2)
        user.add(user3)
        user.add(pablo)
        user.add(user1)
        user.add(user2)
        user.add(user3)
        user.add(pablo)
        user.add(user1)
        user.add(user2)
        user.add(user3)
        user.add(pablo)
        user.add(user1)
        user.add(user2)
        user.add(user3)
        user.add(pablo)
        user.add(user1)
        user.add(user2)
        user.add(user3)
        user.add(pablo)
        user.add(user1)
        user.add(user2)
        user.add(user3)
        return user
    }
}