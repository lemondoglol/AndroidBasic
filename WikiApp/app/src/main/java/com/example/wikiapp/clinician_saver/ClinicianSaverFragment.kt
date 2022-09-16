package com.example.wikiapp.clinician_saver

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint
import java.time.ZonedDateTime
import java.util.*

@AndroidEntryPoint
class ClinicianSaverFragment : Fragment() {

    private val viewModel: ClinicianSaverFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(modifier = Modifier.fillMaxSize()) {

//                    ClinicianSaverFragmentScreen(
//                        modifier = Modifier.fillMaxSize(),
//                        handler = viewModel
//                    )
//                    HtmlText(
//                        modifier = Modifier.fillMaxSize(),
//                        html = """
//                            https://www.youtube.com
//                        """.trimIndent()
//                    )

                    Text(
                        modifier = Modifier.clickable {
                            showDatePicker(
                                requireActivity(),
                                viewModel::updateDatePick,
                            )
                        },
                        text = viewModel.datePick
                    )
                }
            }
        }
    }

    private fun showDatePicker(
        activity: FragmentActivity,
        onDatePicked: (Long?) -> Unit,
        validDate: List<Long> = emptyList(),
    ) {
        val zonedDateTimeOffSet = ZonedDateTime.now().offset.totalSeconds.times(1000L)

        // define date validator
        val dateValidator = object : CalendarConstraints.DateValidator {
            override fun describeContents(): Int {
                return Parcelable.CONTENTS_FILE_DESCRIPTOR
            }

            override fun writeToParcel(p0: Parcel?, p1: Int) {}

            override fun isValid(date: Long): Boolean {
                val offSet = ZonedDateTime.now().offset.totalSeconds
                // this date is in utc
                return validDate.contains(date - offSet * 1000)
            }
        }

        // set calendar constraint
        val today = MaterialDatePicker.todayInUtcMilliseconds()
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))

        calendar.timeInMillis = today
        calendar[Calendar.MONTH] = Calendar.AUGUST
        val janThisYear = calendar.timeInMillis

        calendar.timeInMillis = today
        calendar[Calendar.MONTH] = Calendar.DECEMBER
        val decThisYear = calendar.timeInMillis

        // Build constraints.
        val constraintsBuilder =
            CalendarConstraints.Builder()
                .setStart(janThisYear)
                .setEnd(decThisYear)

        val builder = MaterialDatePicker.Builder.datePicker().apply {
            this.setTitleText("Im the title")
//            this.setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            this.setCalendarConstraints(
                constraintsBuilder
                    .setValidator(dateValidator)
                    .build()
            )
        }
        val datePicker = builder.build().apply {
            this.addOnPositiveButtonClickListener {
                Toast.makeText(activity, "Date selected $it", Toast.LENGTH_SHORT).show()
                val offSet = ZonedDateTime.now().offset.totalSeconds
                onDatePicked(it - offSet * 1000)
            }
        }

        datePicker.show(activity.supportFragmentManager, datePicker.toString())
    }

    @Composable
    fun HtmlText(
        modifier: Modifier = Modifier,
        html: String,
    ) {
        AndroidView(
            modifier = modifier,
            factory = { context -> TextView(context) },
            update = { it.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY) },
        )
    }
}
