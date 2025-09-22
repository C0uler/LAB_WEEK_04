import android.content.res.Resources
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jordan.lab_week_04.CafeDetailFragment
import com.jordan.lab_week_04.TABS_DESC
import com.jordan.lab_week_04.TABS_FIXED


class CafeAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val resources: Resources
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return TABS_FIXED.size
    }

    override fun createFragment(position: Int): Fragment {
        // 1. Get the description resource ID from the list
        val descResId = TABS_DESC[position]

        // This line will now work because 'resources' is guaranteed to be not null
        val descriptionString = resources.getString(descResId)


        // 3. ✅ Call the unchanged newInstance method with the description string
        return CafeDetailFragment.newInstance(descriptionString)
    }
}